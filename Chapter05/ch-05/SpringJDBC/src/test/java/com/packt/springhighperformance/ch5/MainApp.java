package com.packt.springhighperformance.ch5;

import java.sql.SQLException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.packt.springhighperformance.ch5.bankingapp.app.AppConfig;
import com.packt.springhighperformance.ch5.bankingapp.dao.AccountDao;
import com.packt.springhighperformance.ch5.bankingapp.model.Account;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AppConfig.class);
		AccountDao accountDao = applicationContext.getBean(AccountDao.class);
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAccountName("abc");
		accountDao.insertAccountWithJdbcTemplate(account);
		accountDao.getAccountdetails();
		applicationContext.close();
	}
}