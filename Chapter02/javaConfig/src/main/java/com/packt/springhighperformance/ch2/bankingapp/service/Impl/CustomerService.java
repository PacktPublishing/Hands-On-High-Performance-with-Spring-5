package com.packt.springhighperformance.ch2.bankingapp.service.Impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerService {

	@Bean
	public void showCustomerAccountBalance() {
		System.out.println("This is call customer services");

	}

}
