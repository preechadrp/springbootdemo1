package com.mycom.springbootdemo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycom.springbootdemo1.entity.OrderItem;
import com.mycom.springbootdemo1.repository.OrderItemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class Springbootdemo1ApplicationTests {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Test
	void contextLoads() {
		log.info("junit : contextLoads");
		for (int idx = 1; idx <= 5; idx++) {
			OrderItem orderItem = new OrderItem()
					.setOrderId(idx)
					.setItemNo(idx)
					.setProductName("Product" + idx)
					.setQuantity(10 + idx);

			log.info("orderItem : {}", orderItem.toString());
			orderItemRepository.save(orderItem);
		}

	}

}
