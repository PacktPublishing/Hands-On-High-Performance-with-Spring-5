package com.packt.springhighperformance.ch5.bankingapp.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
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
	public void insertAccountWithJdbcTemplate(Account account) {
		String query = "INSERT INTO ACCOUNT (accountNumber,accountName) VALUES (?,?)";		
		Object[] inputs = new Object[] { account.getAccountNumber(), account.getAccountName() };
		jdbcTemplate.update(query, inputs);
		LOGGER.info("Inserted into Account Table Successfully");

	}

	@Override
	public Account getAccountdetails() {
		String query = "SELECT accountNumber, accountName FROM ACCOUNT ";
		
		Account account = jdbcTemplate.queryForObject(query, new RowMapper<Account>(){
			public Account mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Account account = new Account();
				account.setAccountNumber(rs.getInt("accountNumber"));
				account.setAccountName(rs.getString("accountName"));				
				return account;
			}});
		LOGGER.info("Account Details : "+account);
		return account;			
	}

}
