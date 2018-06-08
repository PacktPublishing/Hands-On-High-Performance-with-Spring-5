package com.packt.springhighperformance.ch09.accountingservice;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.packt.springhighperformance.ch09.accountingservice.models.Account;
import com.packt.springhighperformance.ch09.accountingservice.repositories.AccountsRepository;

@Component
public class AccountsDataRunner implements ApplicationRunner {

	@Autowired
	private AccountsRepository acctRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Stream.of("Savings", "Current", "Recurring", "Fixed Deposit")
				.forEach(name -> acctRepository.save(new Account(name)));
		acctRepository.findAll().forEach(System.out::println);
	}

}
