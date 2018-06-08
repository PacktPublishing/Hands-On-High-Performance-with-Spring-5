package com.packt.springhighperformance.ch1.bankingapp.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packt.springhighperformance.ch1.bankingapp.BankAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Beans.xml"})
public class MainTest {
	
	private static final Logger LOGGER = Logger.getLogger(MainTest.class);

	@Autowired
	BankAccount bankAccount;
	
	@Test
	public void findAccountById(){
		LOGGER.info(bankAccount.getAccountType());
	}

}
