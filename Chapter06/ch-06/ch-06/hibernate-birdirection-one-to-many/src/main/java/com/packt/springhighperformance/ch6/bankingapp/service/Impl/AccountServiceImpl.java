package com.packt.springhighperformance.ch6.bankingapp.service.Impl;

import com.packt.springhighperformance.ch6.bankingapp.dao.IAccountDAO;
import com.packt.springhighperformance.ch6.bankingapp.model.Account;
import com.packt.springhighperformance.ch6.bankingapp.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private IAccountDAO accountDAO = null;

	public AccountServiceImpl(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public Account findAccountById(Long accountId) {
		return this.accountDAO.findOne(accountId);
	}
}
