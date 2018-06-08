package com.packt.springhighperformance.ch1.bankingapp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("Beans.xml");
		BankAccount obj = (BankAccount) beanFactory.getBean("bankAccount");
		LOGGER.info(obj.getAccountType());
	}
}
