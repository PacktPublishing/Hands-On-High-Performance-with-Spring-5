package com.packt.springhighperformance.ch6;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
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
public class TestBulkOperation {
	
	private static final Logger _logger = Logger.getLogger(TestBulkOperation.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Test
	@Transactional
	public void testBulkOperation(){
		this.performBulkUpdateIssue();
		this.performBulkUpdateResolution();
	}
	
	private void performBulkUpdateIssue(){
		Account account = this.entityManager.find(Account.class, 7L);
		
		entityManager.createNativeQuery("UPDATE account a SET name = name || '-changed'").executeUpdate();
		_logger.warn("Issue with Account Name: "+account.getName());

		account = this.entityManager.find(Account.class, 7L);
		_logger.warn("Issue with Account Name: "+account.getName());
	}
	
	private void performBulkUpdateResolution(){
		//make sure you are passing right account id
		
		Account account = this.entityManager.find(Account.class, 7L);

		//remove from persistence context
		entityManager.flush();
		entityManager.detach(account);
		entityManager.createNativeQuery("UPDATE account a SET name = name || '-changed'").executeUpdate();
		_logger.warn("Resolution Account Name: "+account.getName());
		
		account = this.entityManager.find(Account.class, 7L);
		_logger.warn("Resolution Account Name: "+account.getName());
	}
}
