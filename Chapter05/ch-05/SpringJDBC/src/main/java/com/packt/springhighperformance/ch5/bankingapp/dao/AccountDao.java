package com.packt.springhighperformance.ch5.bankingapp.dao;

import com.packt.springhighperformance.ch5.bankingapp.model.Account;

public interface AccountDao {
 
    public void insertAccountWithJdbcTemplate(Account account);
    public Account getAccountdetails();
}