package com.packt.springhighperformance.ch4.bankingapp.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class BankAsyncService {

	private static final Logger LOGGER = Logger.getLogger(BankAsyncService.class);

	@Async
	public Future<String> syncCustomerAccount() throws InterruptedException {
		LOGGER.info("Sync Account Processing Started - Thread id: " + Thread.currentThread().getId());

		// Sleeps 2s
		Thread.sleep(2000);

		String processInfo = String.format("Sync Account Processing Completed - Thread Name= %d, Thread Name= %s",
				Thread.currentThread().getId(), Thread.currentThread().getName());

		LOGGER.info(processInfo);

		return new AsyncResult<String>(processInfo);
	}
	
	@Async
	public CompletableFuture<String> syncCustomerDetails() {
		LOGGER.info("Sync Customer Details Processing Started - Thread id: " + Thread.currentThread().getId());

		CompletableFuture<String> future = new CompletableFuture<String>() {
	           @Override
	           public String get () throws InterruptedException, ExecutionException {
		        	// Sleeps 2s
		       		Thread.sleep(2000);
		    		String processInfo = String.format("Sync Customer Details Processing Completed - Thread Name= %d, Thread Name= %s",
		    				Thread.currentThread().getId(), Thread.currentThread().getName());
		    		LOGGER.info(processInfo);
					return processInfo;
	           }
	    };
		return future;
	}
	
	@Async
	public CompletableFuture<String> syncCustomerBalance() {
		LOGGER.info("Sync Customer Balance Processing Started - Thread id: " + Thread.currentThread().getId());

		CompletableFuture<String> future = new CompletableFuture<String>() {
	           @Override
	           public String get () throws InterruptedException, ExecutionException {
		        	// Sleeps 2s
		       		Thread.sleep(2000);
		    		String processInfo = String.format("Sync Customer Balance Processing Completed - Thread Name= %d, Thread Name= %s",
		    				Thread.currentThread().getId(), Thread.currentThread().getName());
		    		LOGGER.info(processInfo);
					return processInfo;
	           }
	    };
		return future;
	}
}
