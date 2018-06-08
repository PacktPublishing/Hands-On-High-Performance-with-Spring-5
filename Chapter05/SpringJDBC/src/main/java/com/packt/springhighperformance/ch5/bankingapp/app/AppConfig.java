package com.packt.springhighperformance.ch5.bankingapp.app;

import javax.sql.DataSource; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.packt.springhighperformance.ch5.bankingapp.dao.AccountDao;
import com.packt.springhighperformance.ch5.bankingapp.dao.Impl.AccountDaoImpl;
 
@Configuration
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //Postgres database we are using
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TestDB");
        dataSource.setUsername("test");
        dataSource.setPassword("test");
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
 
    @Bean
    public AccountDao accountDao(){
    	AccountDaoImpl accountDao = new AccountDaoImpl();
    	accountDao.setJdbcTemplate(jdbcTemplate());
        return accountDao;
    }
 
}