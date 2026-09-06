package com.mycom.springbootdemo1.component.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@ConfigurationProperties(prefix = "app.common")
@Slf4j
public class CommonProperties {

	private String name;
	private String description;
	private String version;
	private String db1Url;
	private String db1Username;
	private String db1Password;
	private String proxyHost;
	private int proxyPort;
	private String proxyUsername;
	private String proxyPassword;

	@PostConstruct
	public void printProperties() {
		log.info("Common Properties:");
		log.info("Name: {}", name);
		log.info("Description: {}", description);
		log.info("Version: {}", version);
		log.info("DB1 URL: {}", db1Url);
		log.info("DB1 Username: {}", db1Username);
		log.info("DB1 Password: {}", db1Password);
		log.info("Proxy Host: {}", proxyHost);
		log.info("Proxy Port: {}", proxyPort);
		log.info("Proxy Username: {}", proxyUsername);
		log.info("Proxy Password: {}", proxyPassword);
	}
}
