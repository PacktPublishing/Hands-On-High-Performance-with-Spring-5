package com.packt.springhighperformance.ch5.bankingapp.dao.Impl;


import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.packt.springhighperformance.ch5.bankingapp.dao.AccountDao;
import com.packt.springhighperformance.ch5.bankingapp.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	private static final Logger LOGGER = Logger.getLogger(AccountDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public void insertAccountWithJdbcTemplate(Account account) {
		String query = "INSERT INTO ACCOUNT (accountNumber,accountName) VALUES (?,?)";		
		Object[] inputs = new Object[] { account.getAccountNumber(), account.getAccountName() };
		jdbcTemplate.update(query, inputs);
		LOGGER.info("Inserted into Account Table Successfully");
		throw new RuntimeException("simulate Error condition");
	}

}
