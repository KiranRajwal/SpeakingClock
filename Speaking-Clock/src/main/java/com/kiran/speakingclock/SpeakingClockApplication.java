package com.kiran.speakingclock;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpeakingClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingClockApplication.class, args);
	}

}
