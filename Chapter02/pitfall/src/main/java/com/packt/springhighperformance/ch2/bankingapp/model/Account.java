package com.packt.springhighperformance.ch2.bankingapp.model;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Component
public class Account {
	
	private static final Logger LOGGER = Logger.getLogger(Account.class);

	static {
		LOGGER.info("Account | Class loaded");
	}

	@Autowired
	public Account(ListableBeanFactory beanFactory) {
		LOGGER.info("Account | Constructor");
		LOGGER.info("Constructor (Customer?):  {}" + beanFactory.getBeansOfType(Customer.class).keySet());
		LOGGER.info("Constructor (Bank?): {}" + beanFactory.getBeansOfType(Bank.class).keySet());
	}

}