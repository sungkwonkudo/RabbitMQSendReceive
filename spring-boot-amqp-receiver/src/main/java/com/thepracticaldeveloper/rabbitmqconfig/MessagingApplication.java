package com.thepracticaldeveloper.rabbitmqconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessagingApplication {

	public static final String EXCHANGE_NAME = "test.rabbit";
	public static final String QUEUE_GENERIC_NAME = "test.rabbit.queue";
	public static final String QUEUE_SPECIFIC_NAME = "test.rabbit.queue";
	public static final String ROUTING_KEY = "thisisakey";

	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}
}
