package com.packt.springhighperformance.ch2.bankingapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.packt.springhighperformance.ch2.bankingapp.model.BankingService;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BankingService bankingService = context.getBean("bankingService", BankingService.class);
		bankingService.showCustomerAccountBalance();		
	}
}
