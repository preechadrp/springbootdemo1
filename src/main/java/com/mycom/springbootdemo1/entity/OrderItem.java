package com.mycom.springbootdemo1.entity;

import com.mycom.springbootdemo1.entity.pk.OrderItemId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Accessors(chain = true)
@Setter
@Getter
@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class) // ประกาศว่าคลาสนี้ใช้ Composite Key จาก OrderItemId ,ใช้ @IdClass เพื่อระบุว่า Entity นี้มี Primary Key แบบ Composite Key โดยใช้คลาส OrderItemId เป็นตัวแทนของ Composite Key
public class OrderItem {

	@Id // ระบุ @Id ตัวที่ 1
	@Column(name = "order_id", nullable = false, comment = "เลข order") //ไม่อนุญาตให้เป็น null
	private Integer orderId;

	@Id // ระบุ @Id ตัวที่ 2
	@Column(name = "item_no")
	private Integer itemNo;

	@Column(name = "product_name", length = 250, nullable = false, comment = "ชื่อสินค้า") // กำหนดความยาวของ String เป็น 250 และไม่อนุญาตให้เป็น null
	private String productName;

	@Column(name = "quantity")
	private Integer quantity;
}