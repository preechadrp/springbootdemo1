package com.mycom.springbootdemo1.component.schedule;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixSchedule {

	@Scheduled(fixedDelay = 3, initialDelay = 1, timeUnit = TimeUnit.SECONDS)
	public void run() {
		System.out.println("FixedDelaySchedule is running...");
	}
}
