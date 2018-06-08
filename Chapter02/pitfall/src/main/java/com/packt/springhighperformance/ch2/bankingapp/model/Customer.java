package com.packt.springhighperformance.ch2.bankingapp.model;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	private static final Logger LOGGER = Logger.getLogger(Customer.class);

	static {
		LOGGER.info("Customer | Class loaded");
	}

	@Autowired
	public Customer(ListableBeanFactory beanFactory) {
		LOGGER.info("Customer | Constructor");
		LOGGER.info("Account (Account?): {}" + beanFactory.getBeansOfType(Account.class).keySet());
		LOGGER.info("Constructor (Bank?): {}" + beanFactory.getBeansOfType(Bank.class).keySet());
	}

}