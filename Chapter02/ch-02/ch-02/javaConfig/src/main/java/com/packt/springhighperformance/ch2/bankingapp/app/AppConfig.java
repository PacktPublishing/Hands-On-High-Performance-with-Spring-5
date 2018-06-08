package com.packt.springhighperformance.ch2.bankingapp.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.packt.springhighperformance.ch2.bankingapp.model.BankingService;
import com.packt.springhighperformance.ch2.bankingapp.service.Impl.CustomerService;

@Configuration
public class AppConfig {	
	
	@Bean
	public CustomerService showCustomerAccountBalance() {
		return new CustomerService();

	}
	
	@Bean
	public BankingService getBankingService() {
	  return new BankingService();
	}
	
}
