package com.packt.springhighperformance.ch8.createthreads;

import org.apache.log4j.Logger;

public class ThreadExample1 {

	public static void main(String[] args) {
		MyThread1 t = new MyThread1();
		t.start();
	}

}

class MyThread1 extends Thread {
	private static final Logger LOGGER = Logger.getLogger(MyThread1.class);
	public void run() {
		LOGGER.info("Hello from thread...");
	}
}
