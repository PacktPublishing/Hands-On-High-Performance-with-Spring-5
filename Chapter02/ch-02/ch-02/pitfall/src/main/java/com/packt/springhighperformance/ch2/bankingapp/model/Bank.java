package com.packt.springhighperformance.ch2.bankingapp.model;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Bank {
	
	private static final Logger LOGGER = Logger.getLogger(Bank.class);

	static {
		LOGGER.info("Bank | Class loaded");
	}

	public Bank() {
		LOGGER.info("Bank | Constructor");
	}

}