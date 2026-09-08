package com.mycom.springbootdemo1.repository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.springbootdemo1.dto.CustOrderSummary;
import com.mycom.springbootdemo1.entity.CustOrder;

@Repository
public interface CustOrderRepository extends JpaRepository<CustOrder, Integer> {

	Optional<CustOrder> findByCustomerName(String customerName);

	@Query("SELECT c FROM CustOrder c WHERE c.totalAmount >= :total_amount")
	List<CustOrder> findTotalAmountEqualAndGreaterthan(@Param("total_amount") BigDecimal totalAmount);

	@Query(value = """
			SELECT * FROM CustOrder WHERE orderid != :orderId and totalAmount >= :total_amount
			""", nativeQuery = true)
	List<CustOrder> findTotalAmountByNativeSql(@Param("orderId") Integer orderId, @Param("total_amount") BigDecimal totalAmount);

	//update โดยใช้ Native SQL
	// ใส่ clearAutomatically = true เพื่อไม่ให้ค่าเก่าค้างในหน่วยความจำหลังจากอัปเดต
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE CustOrder SET totalAmount = :newPrice WHERE orderId = :orderId", nativeQuery = true)
	int updateTotalAmountByNativeSql(@Param("orderId") Integer orderId, @Param("newPrice") BigDecimal newPrice);

	//update โดยใช้ JPQL
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE CustOrder c SET c.totalAmount = :totalAmount WHERE c.orderId = :orderId")
	int updateTotalAmount(@Param("orderId") Integer orderId, @Param("totalAmount") BigDecimal totalAmount);

	// เปลี่ยนมาใช้ JPQL (Query ระดับ Object) เพื่อดึงข้อมูลใส่ Record/DTO โดยตรง
	// (สมมติว่า CustOrderSummary อยู่ใน com.mycom.springbootdemo1.dto)
	// สังเกตว่าใน JPQL เราจะอ้างอิงชื่อคลาส "CustOrder" แทนชื่อตาราง
	@Query("SELECT new com.mycom.springbootdemo1.dto.CustOrderSummary(c.customerName, c.totalAmount) FROM CustOrder c")
	List<CustOrderSummary> findAllProductSummaries();

}