package com.packt.springhighperformance.ch2.bankingapp.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.packt.springhighperformance.ch2.bankingapp.service.CustomerService;
import com.packt.springhighperformance.ch2.bankingapp.service.Impl.CustomerServiceImpl;

@Configuration
@ComponentScan(basePackages="com.packt.springhighperformance.ch2.bankingapp.model")
public class AppConfig {	
	
	@Bean
	public CustomerService showCustomerAccountBalance() {
		return new CustomerServiceImpl();

	}
	
}
