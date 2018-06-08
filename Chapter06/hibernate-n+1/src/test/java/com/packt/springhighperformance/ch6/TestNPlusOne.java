package com.packt.springhighperformance.ch6;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
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

@Rollback(false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, PersistenceJPAConfig.class})
public class TestNPlusOne {
	
	@Autowired
	private AccountService accountService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	private static final Logger _logger = Logger.getLogger(TestNPlusOne.class); 
	
	@Test
	public void testNPlus1Issue(){
		_logger.info(":::::::::::::::N+1 Issue:::::::::::::::");
		Account account = accountService.findAccountById(7L);
		List<Transaction> lTransactions = account.getTransactions();

		for(Transaction transaction : lTransactions){
			_logger.info("Description::" + transaction.getDescription());
			_logger.info("Credit Amount::" + transaction.getCreditAmount());
			_logger.info("Debit Amount::" + transaction.getDebitAmount());
		}
	}
	
	@Test
	public void testJoinFetch(){
		_logger.info(":::::::::::::::JOIN FETCH:::::::::::::::");
		Account account = accountService.findAccountUsingJoinFetch(7L);
		
		List<Transaction> lTransactions =  account.getTransactions();
		
		for(Transaction transaction : lTransactions){
			_logger.info("Description::" + transaction.getDescription());
			_logger.info("Credit Amount::" + transaction.getCreditAmount());
			_logger.info("Debit Amount::" + transaction.getDebitAmount());
		}
	}

	@Test
	public void testCriteriaAPIFetch(){
		_logger.info(":::::::::::::::Criteria API Fetch:::::::::::::::");
		Account account = accountService.findAccountUsingCriteriaAPI(7L);
		
		List<Transaction> lTransactions =  account.getTransactions();
		
		for(Transaction transaction : lTransactions){
			_logger.info("Description::" + transaction.getDescription());
			_logger.info("Credit Amount::" + transaction.getCreditAmount());
			_logger.info("Debit Amount::" + transaction.getDebitAmount());
		}
	}

	@Test
	public void testNamedEntityGraph(){
		_logger.info(":::::::::::::::Named Entity Graph:::::::::::::::");
		Account account = accountService.findAccountUsingNamedEntityGraph(7L);
		
		List<Transaction> lTransactions =  account.getTransactions();
		
		for(Transaction transaction : lTransactions){
			_logger.info("Description::" + transaction.getDescription());
			_logger.info("Credit Amount::" + transaction.getCreditAmount());
			_logger.info("Debit Amount::" + transaction.getDebitAmount());
		}
	}

	@Test
	public void testDynamicEntityGraph(){
		_logger.info(":::::::::::::::Dynamic Entity Graph:::::::::::::::");
		Account account = accountService.findAccountUsingDynamicEntityGraph(7L);
		
		List<Transaction> lTransactions =  account.getTransactions();
		
		for(Transaction transaction : lTransactions){
			_logger.info("Description::" + transaction.getDescription());
			_logger.info("Credit Amount::" + transaction.getCreditAmount());
			_logger.info("Debit Amount::" + transaction.getDebitAmount());
		}
	}

	
}
