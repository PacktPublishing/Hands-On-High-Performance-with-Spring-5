package com.packt.springhighperformance.ch6.bankingapp.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.packt.springhighperformance.ch6.bankingapp.dao.IAccountDAO;
import com.packt.springhighperformance.ch6.bankingapp.dao.impl.AccountDAO;
import com.packt.springhighperformance.ch6.bankingapp.service.AccountService;
import com.packt.springhighperformance.ch6.bankingapp.service.Impl.AccountServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public IAccountDAO accountDAO(){
		return new AccountDAO();
	}
	
	@Bean
	public AccountService accountService(){
		return new AccountServiceImpl(accountDAO());
	}
	
}
