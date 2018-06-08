package com.packt.springhighperformance.ch03.bankingapp.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.packt.springhighperformance.ch03.bankingapp.model.Account;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;

public class TransferServiceImpl implements TransferService {

	private static final Logger LOGGER = LogManager.getLogger(TransferServiceImpl.class);

	@Override
	public boolean transfer(Account source, Account dest, int amount) {
		// transfer amount from source account to dest account
		LOGGER.info("Tranfering " + amount + " from " + source.getAccountName() + " to " + dest.getAccountName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		}
		return true;
	}
}
