package com.mycom.springbootdemo1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycom.springbootdemo1.component.properties.CommonProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloWorldService {

	@Value("${app.common.name}")
	private String commonName;

	private final CommonProperties commonProperties;

	public HelloWorldService(CommonProperties commonProperties) {
		this.commonProperties = commonProperties;
	}

	public String hello() {
		log.info("HelloWorldService.hello() called");
		log.info("commonName: {}", commonName);
		log.info("commonName: {}", this.commonProperties.getName());
		return "Hello World!";
	}

}
