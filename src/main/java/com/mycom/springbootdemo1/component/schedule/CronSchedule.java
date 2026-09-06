package com.mycom.springbootdemo1.component.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronSchedule {

	@Scheduled(cron = "0/5 * * * * *")
	public void run() {
		System.out.println("CronSchedule is running...");
	}
}
