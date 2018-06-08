package com.packt.springhighperformance.ch6.bankingapp.service;

import com.packt.springhighperformance.ch6.bankingapp.model.Account;

public interface AccountService {
	Account findAccountById(Long accountId);
}
