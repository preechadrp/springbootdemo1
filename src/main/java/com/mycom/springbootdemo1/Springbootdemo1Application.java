package com.mycom.springbootdemo1;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mycom.springbootdemo1.entity.CustOrder;
import com.mycom.springbootdemo1.entity.OrderItem;
import com.mycom.springbootdemo1.repository.CustOrderRepository;
import com.mycom.springbootdemo1.repository.OrderItemRepository;

@EnableScheduling
@SpringBootApplication
public class Springbootdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo1Application.class, args);
	}

	@Bean
	CommandLineRunner custOrder(CustOrderRepository custOrderRepository) {
		return (args) -> {
			System.out.println("Spring Boot Application is running...");

			for (int idx = 1; idx <= 5; idx++) {
				CustOrder custOrder = new CustOrder()
						.setOrderId(idx)
						.setCustomerName("Customer" + idx)
						.setTotalAmount(new BigDecimal(1000.00 * idx))
						.setInsertDateTime(java.time.LocalDateTime.now());

				custOrderRepository.save(custOrder);
			}

		};
	}

	@Bean
	CommandLineRunner orderItem(OrderItemRepository orderItemRepository) {
		return (args) -> {
			System.out.println("Spring Boot Application is running...");

			for (int idx = 1; idx <= 5; idx++) {
				OrderItem orderItem = new OrderItem()
						.setOrderId(idx)
						.setItemNo(idx)
						.setProductName("Product" + idx)
						.setQuantity(10 + idx);

				orderItemRepository.save(orderItem);
			}

		};
	}

}
