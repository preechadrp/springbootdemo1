package com.mycom.springbootdemo1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.springbootdemo1.entity.OrderItem;
import com.mycom.springbootdemo1.entity.pk.OrderItemId;
import com.mycom.springbootdemo1.repository.OrderItemRepository;

@RestController
public class OrderItemController {

	private OrderItemRepository orderItemRepository;

	public OrderItemController(OrderItemRepository orderItemRepository) {
		this.orderItemRepository = orderItemRepository;
	}

	@GetMapping("/order-items")
	public List<OrderItem> getOrderItems() {
		return orderItemRepository.findAll();
	}

	@GetMapping("/order-items/{orderId}/{itemNo}")
	public OrderItem getOrderItemById(@PathVariable Integer orderId, @PathVariable Integer itemNo) {
		OrderItemId orderItemId = new OrderItemId(orderId, itemNo);
		return orderItemRepository.findById(orderItemId).orElse(null);
	}

	@GetMapping("/order-items/product/{productName}")
	public OrderItem getOrderItemByProductName(@PathVariable String productName) {
		return orderItemRepository.findByProductName(productName);
	}
}
