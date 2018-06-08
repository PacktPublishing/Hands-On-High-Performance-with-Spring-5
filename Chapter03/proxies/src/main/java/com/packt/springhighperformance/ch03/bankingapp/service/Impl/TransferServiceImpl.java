package com.packt.springhighperformance.ch03.bankingapp.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.aop.framework.AopContext;

import com.packt.springhighperformance.ch03.bankingapp.model.Account;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;

public class TransferServiceImpl implements TransferService {
	private static final Logger LOGGER = Logger.getLogger(TransferServiceImpl.class);

	@Override
	public boolean transfer(Account source, Account dest, Double amount) {
		// transfer amount from source account to dest account
		LOGGER.info("Tranfering " + amount + " from " + source.getAccountName() + " to " + dest.getAccountName());
		((TransferService)(AopContext.currentProxy())).checkBalance(source);
		return true;
	}

	@Override
	public double checkBalance(Account a) {
		return 0;
	}
}
