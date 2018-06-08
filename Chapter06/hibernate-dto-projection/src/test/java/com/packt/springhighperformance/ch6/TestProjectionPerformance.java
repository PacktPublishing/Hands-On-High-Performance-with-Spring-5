package com.packt.springhighperformance.ch6;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.jpa.QueryHints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packt.springhighperformance.ch6.bankingapp.app.AppConfig;
import com.packt.springhighperformance.ch6.bankingapp.app.PersistenceJPAConfig;
import com.packt.springhighperformance.ch6.bankingapp.model.Account;

@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, PersistenceJPAConfig.class})
public class TestProjectionPerformance {
	
	private static final Logger _logger = Logger.getLogger(TestProjectionPerformance.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Test
	@Transactional
	public void testOneToManyBidirectional(){
		this.findAccountUsingTraditional();
		this.findAccountUsingQueryHint();
		this.findAccountUsingImmutable();
		this.findAccountUsingDto();
	}
	
	private void findAccountUsingTraditional(){
		long timeQuery = 0;
		long iterations = 1000;
		// Perform 1000 iterations
		for (int i = 0; i < iterations; i++) {
		    long startQuery = System.currentTimeMillis();
		    List<Account> lAccounts= entityManager.createQuery("SELECT a FROM Account a").getResultList();
		    long endQuery = System.currentTimeMillis();
		    timeQuery += endQuery - startQuery;
		}
		_logger.warn("Query Traditional: total " + timeQuery + " ms per iteration " + timeQuery / (double)iterations);
	}
	
	private void findAccountUsingQueryHint(){
		long timeQuery = 0;
		long iterations = 1000;
		// Perform 1000 iterations
		for (int i = 0; i < iterations; i++) {
		    long startQuery = System.currentTimeMillis();
		    List<Account> lAccounts= entityManager.createQuery("SELECT a FROM Account a").setHint(QueryHints.HINT_READONLY, true).getResultList();
		    long endQuery = System.currentTimeMillis();
		    timeQuery += endQuery - startQuery;
		}
		_logger.warn("Query Hint: total " + timeQuery + " ms per iteration " + timeQuery / (double)iterations);
	}
	
	private void findAccountUsingImmutable(){
		long timeQuery = 0;
		long iterations = 1000;
		// Perform 1000 iterations
		for (int i = 0; i < iterations; i++) {
		    long startQuery = System.currentTimeMillis();
		    List<Account> lAccounts= entityManager.createQuery("SELECT a FROM AccountImmutable a").getResultList();
		    long endQuery = System.currentTimeMillis();
		    timeQuery += endQuery - startQuery;
		}
		_logger.warn("Query Immutable: total " + timeQuery + " ms per iteration " + timeQuery / (double)iterations);
	}
	
	private void findAccountUsingDto(){
		long timeQuery = 0;
		long iterations = 1000;
		// Perform 1000 iterations
		for (int i = 0; i < iterations; i++) {
		    long startQuery = System.currentTimeMillis();
		    List<Account> lAccounts= entityManager.createQuery("SELECT new com.packt.springhighperformance.ch6.bankingapp.dto.AccountDto(a.id, a.name) FROM Account a").getResultList();
		    long endQuery = System.currentTimeMillis();
		    timeQuery += endQuery - startQuery;
		}
		_logger.warn("Query DTO: total " + timeQuery + " ms per iteration " + timeQuery / (double)iterations);
	}
}
