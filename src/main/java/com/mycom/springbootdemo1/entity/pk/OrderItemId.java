package com.mycom.springbootdemo1.entity.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// กฎข้อ 2: มี Default Constructor
@NoArgsConstructor
@AllArgsConstructor
// กฎข้อ 3: Override equals และ hashCode
@EqualsAndHashCode
public class OrderItemId implements Serializable { // กฎข้อ 1: implements Serializable
	private Integer orderId;
	private Integer itemNo;
}