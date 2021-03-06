package com.packt.springhighperformance.ch6.bankingapp.dao;

import java.util.List;

import com.packt.springhighperformance.ch6.bankingapp.model.Account;

public interface IAccountDAO {

	Account findOne(Long accountId);

	List<Account> findAll();

	void create(Account entity);

	Account update(Account account);

	void delete(Account account);

	void deleteById(Long accountId);

}
