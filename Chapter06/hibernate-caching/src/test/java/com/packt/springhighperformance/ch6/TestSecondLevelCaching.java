package com.packt.springhighperformance.ch6;

import java.text.MessageFormat;

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

import net.sf.ehcache.CacheManager;

@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, PersistenceJPAConfig.class})
public class TestSecondLevelCaching {
	
	private static final Logger _logger = Logger.getLogger(TestSecondLevelCaching.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Test
	public void testSecondLevelCaching(){
		System.out.println(MessageFormat.format("testst {0}", new Object[]{12353}));
//		this.secondLevelCaching();
//		secondLevelCaching2();
//		secondLevelCaching3();
	}
	
	@Transactional
	private void secondLevelCaching(){
		_logger.warn("2nd level cache session 1");
		
		int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
				  .getCache("com.packt.springhighperformance.ch6.bankingapp.model.Account").getSize();
		_logger.warn("Cache size:: "+size);
		
		Account a = this.entityManager.find(Account.class, 7L);
		_logger.warn(a);
	}
	
	@Transactional
	private void secondLevelCaching2(){
		_logger.warn("2nd level cache session 2");
		
		int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
				  .getCache("com.packt.springhighperformance.ch6.bankingapp.model.Account").getSize();
		_logger.warn("Cache size:: "+size);
		
		Account a = this.entityManager.find(Account.class, 7L);
		_logger.warn(a);
	}
	
	@Transactional
	private void secondLevelCaching3(){
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			_logger.error(e);
		}
		
		_logger.warn("2nd level cache session 3");
		int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
				  .getCache("com.packt.springhighperformance.ch6.bankingapp.model.Account").getSize();
		_logger.warn("Cache size:: "+size);

		Account a = this.entityManager.find(Account.class, 7L);
		_logger.warn(a);
	}
}
