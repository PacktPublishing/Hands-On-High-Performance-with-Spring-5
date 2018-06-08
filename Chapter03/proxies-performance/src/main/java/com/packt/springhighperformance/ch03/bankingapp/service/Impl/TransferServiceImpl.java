package com.packt.springhighperformance.ch03.bankingapp.service.Impl;

import com.packt.springhighperformance.ch03.bankingapp.model.Account;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;

public class TransferServiceImpl implements TransferService {

	@Override
	public boolean transfer(Account source, Account dest, int amount) {
		// transfer amount from source account to dest account
		return true;
	}
}
