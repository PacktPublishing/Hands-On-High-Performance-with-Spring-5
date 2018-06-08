package com.packt.springhighperformance.ch5.bankingapp.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class coreJDBC{
	
	public static void main(String[] args) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//Postgres database we are using
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TestDB");
        dataSource.setUsername("test");
        dataSource.setPassword("test");        
        
		String query = "SELECT COUNT(*) FROM ACCOUNT";	    
	    try (Connection conn = dataSource.getConnection();
	    		Statement statement =  conn.createStatement(); 
	    		ResultSet rsltSet = statement.executeQuery(query)) 
	    {
	      if(rsltSet.next()){ 
	      int count = rsltSet.getInt(1);
	      System.out.println("count : " + count);
	      }
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }   
	    
	}

}
