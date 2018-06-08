package com.packt.springhighperformance.ch2.bankingapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.packt.springhighperformance.ch2.bankingapp.app.AppConfig;
import com.packt.springhighperformance.ch2.bankingapp.model.Account;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Account account = context.getBean(Account.class);
		context.close();
	}
}
