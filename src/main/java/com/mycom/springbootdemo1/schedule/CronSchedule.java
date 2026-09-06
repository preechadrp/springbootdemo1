package com.mycom.springbootdemo1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CronSchedule {

	@Scheduled(cron = "0/5 * * * * *")
	public void run() {
		log.info("CronSchedule is running...");
	}

	@Scheduled(cron = "* * 0 * * MON-FRI")
	public void run2() {
		log.info("CronSchedule is running... at 0.00 every day between monday and friday");
	}

	@Scheduled(cron = "* * 0 * * MON,WED,FRI")
	public void run3() {
		log.info("CronSchedule is running... at 0.00 at monday, wednesday, friday");
	}
}
