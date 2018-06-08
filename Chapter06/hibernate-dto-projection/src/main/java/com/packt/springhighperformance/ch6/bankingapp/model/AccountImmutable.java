package com.packt.springhighperformance.ch6.bankingapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "account")
public class AccountImmutable implements Serializable {

	private static final long serialVersionUID = 1232821417960547743L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id", updatable = false, nullable = false)
	private Long accountId;
	private String name;
	
	@OneToMany(mappedBy = "account", fetch=FetchType.LAZY)
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
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
		AccountImmutable other = (AccountImmutable) obj;
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
