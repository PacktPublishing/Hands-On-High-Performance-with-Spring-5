package com.packt.springhighperformance.ch2.bankingapp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.packt.springhighperformance.ch2.bankingapp.service.Impl.CustomerService;

@Configuration
public class BankingService {

	// Field based Dependency Injection	
	@Autowired
	private CustomerService customerService;

	
	public void showCustomerAccountBalance() {
		customerService.showCustomerAccountBalance();
	}

}
