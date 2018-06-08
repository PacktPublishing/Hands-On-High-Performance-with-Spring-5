package com.packt.springhighperformance.ch2.bankingapp.service.Impl;

import com.packt.springhighperformance.ch2.bankingapp.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void showCustomerAccountBalance() {
		System.out.println("This is call customer services");

	}

}
