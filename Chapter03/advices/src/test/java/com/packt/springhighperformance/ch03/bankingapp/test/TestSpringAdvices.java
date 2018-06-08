package com.packt.springhighperformance.ch03.bankingapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packt.springhighperformance.ch03.bankingapp.config.AppConfig;
import com.packt.springhighperformance.ch03.bankingapp.exception.MinimumAmountException;
import com.packt.springhighperformance.ch03.bankingapp.model.Account;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class TestSpringAdvices {
	
	@Autowired
	private TransferService transferService;
	
	@Test
	public void transferAmount() throws MinimumAmountException{
		Account source = new Account(123456,"Account1");
		Account dest = new Account(987654,"Account2");
		transferService.transfer(source, dest, 100);
	}
	
	@Test
	public void transferAmountException() throws MinimumAmountException{
		Account source = new Account(123456,"Account1");
		Account dest = new Account(987654,"Account2");
		transferService.transfer(source, dest, 9);
	}
}
