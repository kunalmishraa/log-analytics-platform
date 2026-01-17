package com.unifiedlogs.platform;
/**
 * Author : Kunal Mishra
 * Date : 17-01-2026
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LogAnalyticsPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogAnalyticsPlatformApplication.class, args);
	}

}
