package com.mycom.springbootdemo1.repository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycom.springbootdemo1.entity.CustOrder;

@Repository
public interface CustOrderRepository extends JpaRepository<CustOrder, Integer> {

	Optional<CustOrder> findByCustomerName(String customerName);

	@Query("SELECT c FROM CustOrder c WHERE c.totalAmount >= :total_amount")
	List<CustOrder> findTotalAmountEqualAndGreaterthan(@Param("total_amount") BigDecimal totalAmount);

	@Query(value = """
			SELECT * FROM cust_order WHERE orderid != :orderId and totalamount >= :total_amount
			""", nativeQuery = true)
	List<CustOrder> findTotalAmountByNativeSql(@Param("orderId") Integer orderId, @Param("total_amount") BigDecimal totalAmount);

}