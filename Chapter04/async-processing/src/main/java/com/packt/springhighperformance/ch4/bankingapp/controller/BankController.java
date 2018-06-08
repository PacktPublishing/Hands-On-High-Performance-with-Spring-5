package com.packt.springhighperformance.ch4.bankingapp.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.packt.springhighperformance.ch4.bankingapp.service.BankAsyncService;

@Controller
public class BankController {
	
	private static final Logger LOGGER = Logger.getLogger(BankAsyncService.class);
	
	@Autowired
	BankAsyncService syncService;

	@RequestMapping(value = "/syncall")
	@ResponseBody
	public Callable<String> syncAllAccount() {
		LOGGER.info("Entering in controller");

		Callable<String> asyncTask = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Future<String> processSync = syncService.syncCustomerAccount();
				return processSync.get();
			}
		};

		LOGGER.info("Leaving from controller");
		return asyncTask;
	}
	
	@RequestMapping(value = "/syncacct")
	@ResponseBody
	public CompletableFuture<String> syncAccount() {
		LOGGER.info("Entering in controller");

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {

			@Override
			public String get() {
				CompletableFuture<String> future = syncService.syncCustomerDetails();
				try {
					return future.get();
				} catch (InterruptedException | ExecutionException e) {
					LOGGER.error(e);
				}
				return null;
			}
			
		});

		LOGGER.info("Leaving from controller");
		return completableFuture;
	}
	
	@RequestMapping(value = "/synccust")
	@ResponseBody
	public CompletableFuture<String> syncCustomerDetails() {
		LOGGER.info("Entering in controller");

		CompletableFuture<String> completableFuture = new CompletableFuture<>();
	    CompletableFuture.runAsync(new Runnable() {
			
			@Override
			public void run() {
				try {
					completableFuture.complete(syncService.syncCustomerAccount().get());
				} catch (InterruptedException | ExecutionException e) {
					completableFuture.completeExceptionally(e);
				}
				
			}
		}); 
	    LOGGER.info("Leaving from controller");
	    return completableFuture;
	}
	
	@RequestMapping(value = "/synccustbal")
	@ResponseBody
	public CompletableFuture<String> syncCustomerBalance() {
		LOGGER.info("Entering in controller");

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			
			@Override
			public String get() {
				try {
					return syncService.syncCustomerBalance().get();
				} catch (InterruptedException | ExecutionException e) {
					LOGGER.error(e);
				}
				return "No balance found";
			}
		}); 
	    LOGGER.info("Leaving from controller");
	    return completableFuture;
	}
}

