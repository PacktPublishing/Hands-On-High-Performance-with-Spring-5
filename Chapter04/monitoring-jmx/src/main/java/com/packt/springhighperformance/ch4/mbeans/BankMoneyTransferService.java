package com.packt.springhighperformance.ch4.mbeans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@ManagedResource(objectName = "com.packt.springhighperformance.ch4.mbeans : name=BankMoneyTransferService", description = "Transfers money from one account to another")
public class BankMoneyTransferService {

	private Map<String, Integer> accountMap = new HashMap<String, Integer>();
	{
		accountMap.put("12345", 20000);
		accountMap.put("54321", 10000);
	};

	@ManagedOperation(description = "Amount transfer")
	@ManagedOperationParameters({
			@ManagedOperationParameter(name = "sourceAccount", description = "Transfer from account"),
			@ManagedOperationParameter(name = "destinationAccount", description = "Transfer to account"),
			@ManagedOperationParameter(name = "transferAmount", description = "Amount to be transfer") })
	public void transfer(String sourceAccount, String destinationAccount, int transferAmount) {
		if (transferAmount == 0) {
			throw new IllegalArgumentException("Invalid amount");
		}
		int sourceAcctBalance = accountMap.get(sourceAccount);
		int destinationAcctBalance = accountMap.get(destinationAccount);

		if ((sourceAcctBalance - transferAmount) < 0) {
			throw new IllegalArgumentException("Not enough balance.");
		}
		sourceAcctBalance = sourceAcctBalance - transferAmount;
		destinationAcctBalance = destinationAcctBalance + transferAmount;

		accountMap.put(sourceAccount, sourceAcctBalance);
		accountMap.put(destinationAccount, destinationAcctBalance);
	}

	@ManagedOperation(description = "Check Balance")
	public int checkBalance(String accountNumber) {
		if (StringUtils.isEmpty(accountNumber)) {
			throw new IllegalArgumentException("Enter account no.");
		}
		if (!accountMap.containsKey(accountNumber)) {
			throw new IllegalArgumentException("Account not found.");
		}
		return accountMap.get(accountNumber);
	}

}
