package com.packt.springhighperformance.ch7.bankingapp;


import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	private static final Logger LOGGER = Logger.getLogger(Consumer.class);

	@RabbitListener(containerFactory = "listenerContainer",
			queues = RabbitMqConfiguration.RABBIT_MESSAGE_QUEUE)
    public void onMessage(Message message) {
    	LOGGER.info("Received Message: " + new String(message.getBody()));
    }
}
