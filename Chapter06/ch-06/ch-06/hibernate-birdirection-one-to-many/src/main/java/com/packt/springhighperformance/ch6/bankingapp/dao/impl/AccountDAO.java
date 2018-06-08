package com.packt.springhighperformance.ch6.bankingapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.packt.springhighperformance.ch6.bankingapp.dao.AbstractJpaDAO;
import com.packt.springhighperformance.ch6.bankingapp.dao.IAccountDAO;
import com.packt.springhighperformance.ch6.bankingapp.model.Account;

@Repository
public class AccountDAO extends AbstractJpaDAO<Account> implements IAccountDAO {

	public AccountDAO() {
		super();
		setClazz(Account.class);
	}
}
