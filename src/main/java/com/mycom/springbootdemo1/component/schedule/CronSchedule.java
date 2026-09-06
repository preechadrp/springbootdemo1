package com.mycom.springbootdemo1.component.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronSchedule {

	@Scheduled(cron = "0/5 * * * * *")
	public void run() {
		System.out.println("CronSchedule is running...");
	}

	@Scheduled(cron = "* * 0 * * MON-FRI")
	public void run2() {
		System.out.println("CronSchedule is running... at 0.00 every day between monday and friday");
	}

	@Scheduled(cron = "* * 0 * * MON,WED,FRI")
	public void run3() {
		System.out.println("CronSchedule is running... at 0.00 at monday, wednesday, friday");
	}
}
