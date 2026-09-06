package com.mycom.springbootdemo1.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class CustOrder {

	@Id
	@Column(nullable = false, comment = "เลข order") //ไม่อนุญาตให้เป็น null
	private Integer orderId;

	@Column(length = 250, nullable = false, comment = "ชื่อลูกค้า") // กำหนดความยาวของ String เป็น 250 และไม่อนุญาตให้เป็น null
	private String customerName;

	@Column(precision = 18, scale = 2, comment = "ยอดรวมสินค้า")
	private BigDecimal totalAmount;

	@Column(comment = "วันที่สั่งซื้อสินค้า")
	@JsonFormat(pattern = "yyyy-MM-dd") // กำหนดรูปแบบวันที่ในการแสดงผล
	private LocalDate orderDate;

	@Column(comment = "วันที่บันทึกข้อมูล")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") // กำหนดรูปแบบวันที่และเวลาในการแสดงผล
	private LocalDateTime insertDateTime;

}
