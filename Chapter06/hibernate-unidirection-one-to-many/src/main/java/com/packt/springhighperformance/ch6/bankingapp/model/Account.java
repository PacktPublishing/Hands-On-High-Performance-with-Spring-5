package com.packt.springhighperformance.ch6.bankingapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = 1232821417960547743L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id", updatable = false, nullable = false)
	private Long accountId;
	private String name;
	
	@OneToMany
	@JoinColumn(name="account_id")
	private Set<Transaction> transactions = new HashSet<Transaction>();
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccountId() {
		return accountId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Transaction)) {
			return false;
		}
		Account other = (Account) obj;
		if (accountId != null) {
			if (!accountId.equals(other.accountId)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return 61;
	}
	
	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (name != null && !name.trim().isEmpty())
			result += "Account Name: " + name;
		return result;
	}

}
