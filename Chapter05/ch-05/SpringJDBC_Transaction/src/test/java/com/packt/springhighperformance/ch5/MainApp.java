package com.packt.springhighperformance.ch5;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.packt.springhighperformance.ch5.bankingapp.app.AppConfig;
import com.packt.springhighperformance.ch5.bankingapp.dao.AccountDao;
import com.packt.springhighperformance.ch5.bankingapp.model.Account;

public class MainApp {
	
	private static final Logger LOGGER = Logger.getLogger(MainApp.class);

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AppConfig.class);

		AccountDao accountDao = applicationContext.getBean(AccountDao.class);		
		Account account = new Account();
		account.setAccountNumber(202);
		account.setAccountName("xyz");
		accountDao.insertAccountWithJdbcTemplate(account);			 
		applicationContext.close();
	}
}