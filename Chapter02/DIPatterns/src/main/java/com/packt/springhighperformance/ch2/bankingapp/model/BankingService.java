package com.packt.springhighperformance.ch2.bankingapp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.packt.springhighperformance.ch2.bankingapp.service.CustomerService;

@Component
public class BankingService {

	// Field based Dependency Injection
	@Autowired
	private CustomerService customerService;

	// Constructor based Dependency Injection
	@Autowired
	public BankingService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// Setter based Dependency Injection
	// @Autowired
	// public void setCustomerService(CustomerService customerService) {
	// this.customerService = customerService;
	// }

	public void showCustomerAccountBalance() {
		customerService.showCustomerAccountBalance();
	}

}
