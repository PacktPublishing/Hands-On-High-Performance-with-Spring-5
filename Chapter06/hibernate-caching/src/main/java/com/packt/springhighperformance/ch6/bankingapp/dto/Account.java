package com.packt.springhighperformance.ch6.bankingapp.dto;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1232821417960547743L;

	private Long accountId;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccountId() {
		return accountId;
	}
	
	public Account(Long accountId, String name) {
		this.accountId = accountId;
		this.name = name;
	}
}
