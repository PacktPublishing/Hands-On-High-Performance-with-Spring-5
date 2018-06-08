package com.packt.springhighperformance.ch6;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packt.springhighperformance.ch6.bankingapp.app.AppConfig;
import com.packt.springhighperformance.ch6.bankingapp.app.PersistenceJPAConfig;
import com.packt.springhighperformance.ch6.bankingapp.model.Account;
import com.packt.springhighperformance.ch6.bankingapp.model.Transaction;
import com.packt.springhighperformance.ch6.bankingapp.service.AccountService;

@Transactional
@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, PersistenceJPAConfig.class})
public class TestBidirectionalOneToMany {
	
	@Autowired
	private AccountService accountService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Test
	public void testOneToManyBidirectional(){
		Account account = accountService.findAccountById(1L);
		Transaction transaction = new Transaction();
		transaction.setCreditAmount(100.0);
		transaction.setDescription("Salary Credited by Akme Inc.");
		account.addTransaction(transaction);
		entityManager.persist(transaction);
	}

}
