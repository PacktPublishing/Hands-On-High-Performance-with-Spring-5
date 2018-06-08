package com.packt.springhighperformance.ch8.async;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class asyncWithReturnTypeExample {
	private static final Logger LOGGER = Logger.getLogger(asyncWithReturnTypeExample.class);
	public static void main(String[] args)  throws InterruptedException, ExecutionException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		AsyncTask task= ctx.getBean(AsyncTask.class);
		LOGGER.info("calling async method from thread : " + Thread.currentThread().getName());		
		Future<String> future = task.doAsyncTaskWithReturnType();
		while (true) {
	        if (future.isDone()) {
	        	LOGGER.info("Result of asynchronous method - " + future.get());
	            break;
	        }
	        LOGGER.info("Continue doing something else. ");
	        Thread.sleep(1000);
	    }
	}
}