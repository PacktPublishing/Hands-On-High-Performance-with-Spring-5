package com.packt.springhighperformance.ch03.bankingapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packt.springhighperformance.ch03.bankingapp.config.PerformanceInterceptorAppConfig;
import com.packt.springhighperformance.ch03.bankingapp.model.Account;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PerformanceInterceptorAppConfig.class)
public class TestPerformenceInterceptor {


	@Autowired
	private TransferService transferService = null;
	
	@Test
	public void testMethodProfiling(){
		
		Account source = new Account(123456,"Account1");
		Account dest = new Account(987654,"Account2");
		this.transferService.transfer(source, dest, 100);
	}
}
