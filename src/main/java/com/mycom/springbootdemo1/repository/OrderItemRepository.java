package com.mycom.springbootdemo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.springbootdemo1.entity.OrderItem;
import com.mycom.springbootdemo1.entity.pk.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {

	public OrderItem findByProductName(String productName);
}
