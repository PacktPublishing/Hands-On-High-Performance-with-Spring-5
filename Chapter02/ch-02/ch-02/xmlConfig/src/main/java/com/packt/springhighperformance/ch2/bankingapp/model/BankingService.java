package com.packt.springhighperformance.ch2.bankingapp.model;

import com.packt.springhighperformance.ch2.bankingapp.service.CustomerService;

public class BankingService {

	private CustomerService customerService;

	// Constructor based Dependency Injection
	public BankingService(CustomerService customerService) {
	this.customerService = customerService;
	}

	// Setter based Dependency Injection
	// public void setCustomerService(CustomerService customerService) {
	// this.customerService = customerService;
	// }

	public void showCustomerAccountBalance() {
		customerService.showCustomerAccountBalance();
	}

}
