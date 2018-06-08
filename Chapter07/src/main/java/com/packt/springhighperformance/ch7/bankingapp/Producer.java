package com.packt.springhighperformance.ch7.bankingapp;


import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer {

	private static final Logger LOGGER = Logger.getLogger(Producer.class);
	
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMqConfiguration.class);
        RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);
       	LOGGER.info("Sending bank account information....");
        rabbitTemplate.convertAndSend(new BankAccount(100, "Savings Account"));
        rabbitTemplate.convertAndSend(new BankAccount(101, "Current Account"));
        

    }

}
