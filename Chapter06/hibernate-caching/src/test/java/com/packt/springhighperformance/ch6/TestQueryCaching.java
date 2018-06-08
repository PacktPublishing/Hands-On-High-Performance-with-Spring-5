package com.packt.springhighperformance.ch6;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class TestQueryCaching {
	
	private static final Logger _logger = Logger.getLogger(TestQueryCaching.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Test
	public void testQueryCaching(){
		//Enable DEBUG logs and comment cacheable annotation from Account.java
		queryCache();
		queryCache2();
	}
	
	@Transactional
	private void queryCache(){
		_logger.warn("Query Cache");
		Query query = entityManager.createQuery("SELECT a FROM Account a WHERE a.accountId=:accountId", Account.class);
		query.setParameter("accountId", 7L);
		query.setHint("org.hibernate.cacheable", true);
		Account account = (Account)query.getSingleResult();
		_logger.warn(account);
	}
	
	@Transactional
	private void queryCache2(){
		_logger.warn("Query Cache");
		Query query = entityManager.createQuery("SELECT a FROM Account a WHERE a.accountId=:accountId", Account.class);
		query.setParameter("accountId", 7L);
		query.setHint(QueryHints.HINT_CACHEABLE, true);
		Account account = (Account)query.getSingleResult();
		_logger.warn(account);
	}
}
