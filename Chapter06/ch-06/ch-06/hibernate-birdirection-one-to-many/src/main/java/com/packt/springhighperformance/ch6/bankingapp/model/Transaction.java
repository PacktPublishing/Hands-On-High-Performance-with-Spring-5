package com.packt.springhighperformance.ch6.bankingapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = -7051869677975026779L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id", updatable = false, nullable = false)
	private Long transactionId;
	
	@Column(name="creditamt")
	private Double creditAmount;
	
	@Column(name="debitamt")
	private Double debitAmount;

	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "account_id")	
	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTransactionId() {
		return transactionId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Transaction)) {
			return false;
		}
		Transaction other = (Transaction) obj;
		if (transactionId != null) {
			if (!transactionId.equals(other.transactionId)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return 41;
	}

}
