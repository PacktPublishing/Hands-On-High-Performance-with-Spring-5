package com.packt.springhighperformance.ch2.bankingapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.packt.springhighperformance.ch2.bankingapp.app.AppConfig;
import com.packt.springhighperformance.ch2.bankingapp.model.BankingService;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankingService bankingService = context.getBean(BankingService.class);
		bankingService.showCustomerAccountBalance();
		context.close();
	}
}
