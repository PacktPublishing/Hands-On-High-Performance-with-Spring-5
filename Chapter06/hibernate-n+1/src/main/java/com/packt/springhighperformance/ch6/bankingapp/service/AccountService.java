package com.packt.springhighperformance.ch6.bankingapp.service;

import com.packt.springhighperformance.ch6.bankingapp.model.Account;

public interface AccountService {
	Account findAccountById(Long accountId);
	
	Account findAccountUsingJoinFetch(Long accountId);
	
	Account findAccountUsingNamedEntityGraph(Long accountId);
	
	Account findAccountUsingDynamicEntityGraph(Long accountId);
	
	Account findAccountUsingCriteriaAPI(Long accountId);
}
