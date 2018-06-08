package com.packt.springhighperformance.ch2.bankingapp.service.Impl;

import org.springframework.stereotype.Service;

import com.packt.springhighperformance.ch2.bankingapp.service.CustomerService;

//@Component
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public void showCustomerAccountBalance() {
		System.out.println("This is call customer services");
		
	}

}
