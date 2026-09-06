package com.mycom.springbootdemo1.component.schedule;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FixSchedule {

	@Scheduled(fixedDelay = 3, initialDelay = 1, timeUnit = TimeUnit.SECONDS)
	public void runFixedDelay() {
		//งานเสร็จ → รอ 3 วินาที → รอบใหม่
		log.info("FixedDelaySchedule is running...");
	}

	@Scheduled(fixedRate = 3, initialDelay = 1, timeUnit = TimeUnit.SECONDS)
	public void runFixedRate() {
		//พยายามให้แต่ละรอบเริ่มห่างกัน 3 วินาที แต่ก็ต้องรอให้งานเสร็จในกรณีปกติ
		log.info("FixedRateSchedule is running...");
	}
}
