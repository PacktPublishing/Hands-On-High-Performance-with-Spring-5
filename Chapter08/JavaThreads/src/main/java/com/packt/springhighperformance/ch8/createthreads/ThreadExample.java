package com.packt.springhighperformance.ch8.createthreads;

import org.apache.log4j.Logger;

public class ThreadExample {	
	public static void main(String[] args) {
		
		//creating a thread object by implementing Runnable interface.  
		Thread t = new Thread(new MyThread());
		
		//creating Runnable object with use of lambda expression
		//Runnable runnable = () -> LOGGER.info(Hello from thread...");
		//Thread t = new Thread(runnable);
		
		t.start();
	}
}

class MyThread implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(MyThread.class);
	public void run() {
		//perform some task
		LOGGER.info("Hello from thread...");
	}
}