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
		return this.accountDAO.findbyAccountId(accountId);
	}

	@Override
	public Account findAccountUsingJoinFetch(Long accountId) {
		return this.accountDAO.findAccountUsingJoinFetch(accountId);
	}

	@Override
	public Account findAccountUsingNamedEntityGraph(Long accountId) {
		return this.accountDAO.findAccountUsingNamedEntityGraph(accountId);
	}

	@Override
	public Account findAccountUsingDynamicEntityGraph(Long accountId) {
		return this.accountDAO.findAccountUsingDynamicEntityGraph(accountId);
	}

	@Override
	public Account findAccountUsingCriteriaAPI(Long accountId) {
		return this.accountDAO.findAccountUsingCriteriaAPI(accountId);
	}
}
