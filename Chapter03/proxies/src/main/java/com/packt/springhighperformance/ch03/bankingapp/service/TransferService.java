package com.packt.springhighperformance.ch03.bankingapp.service;

import com.packt.springhighperformance.ch03.bankingapp.model.Account;

public interface TransferService {
	
	boolean transfer(Account source, Account dest, int amount);
	
	double checkBalance(Account a);
}
