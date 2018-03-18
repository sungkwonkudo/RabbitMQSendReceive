package com.thepracticaldeveloper.rabbitmqconfig;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
public class MessagingApplication {

	public static final String EXCHANGE_NAME = "test.rabbit";
	public static final String QUEUE_GENERIC_NAME = "test.rabbit.queue";
	public static final String QUEUE_SPECIFIC_NAME = "test.rabbit.queue";
	public static final String ROUTING_KEY = "thisisakey";

	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}

	// You can comment all methods below and remove interface's implementation to use the default serialization / deserialization
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}

}
