package com.packt.springhighperformance.ch8.async;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class asyncExample {
	private static final Logger LOGGER = Logger.getLogger(asyncExample.class);
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		AsyncTask task = ctx.getBean(AsyncTask.class);
		LOGGER.info("calling async method from thread : " + Thread.currentThread().getName());
		task.doAsyncTask();
		LOGGER.info("Continue doing something else. ");
		Thread.sleep(1000);

	}
}