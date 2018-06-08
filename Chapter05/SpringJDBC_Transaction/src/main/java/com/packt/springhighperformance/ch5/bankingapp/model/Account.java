package com.packt.springhighperformance.ch5.bankingapp.model;

public class Account {
	private String accountName;
	private Integer accountNumber;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString(){
		return "{accountNumber="+accountNumber+",accountName="+accountName+"}";
	}
}