package com.packt.springhighperformance.ch8.async;

import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class AsyncTask {
	private static final Logger LOGGER = Logger.getLogger(AsyncTask.class);
	@Async
	public void doAsyncTask() {
		try 
		{
			LOGGER.info("Running Async Task  thread : " + Thread.currentThread().getName());
		} 
		catch (Exception e) {
			//
		}

	}

	@Async
	public Future<String> doAsyncTaskWithReturnType() {
		try 
		{
			return new AsyncResult<String>("Running Async Task  thread : " + Thread.currentThread().getName());
		} 
		catch (Exception e) {
			//
		}
		return null;
	}
}