package com.thepracticaldeveloper.rabbitmqconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomMessageSender {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;


    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        final CustomMessage message = new CustomMessage("Hello there!", new Random().nextInt(50), false);
//        log.info("Sending message...");
        String test = (String)rabbitTemplate.convertSendAndReceive(MessagingApplication.EXCHANGE_NAME, MessagingApplication.ROUTING_KEY, message);
        log.info(test);
    }
}
