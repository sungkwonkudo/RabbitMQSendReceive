package com.thepracticaldeveloper.rabbitmqconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME)
    public String receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
        return "tested 1";
    }

    @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME)
    public String receiveMessage(final CustomMessage customMessage) {
        log.info("Received message as specific class: {}", customMessage.toString());
        return "tested 2";
    }
}
