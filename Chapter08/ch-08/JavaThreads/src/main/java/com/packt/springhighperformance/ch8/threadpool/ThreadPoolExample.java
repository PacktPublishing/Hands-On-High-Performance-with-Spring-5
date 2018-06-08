package com.packt.springhighperformance.ch8.threadpool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.packt.springhighperformance.ch8.concurrent.Task;

public class ThreadPoolExample {
	private static final Logger LOGGER = Logger.getLogger(ThreadPoolExample.class);

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 6; i++) {
			Runnable task = new Task(" " + i);
			executor.execute(task);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		LOGGER.info("All threads finished");
	}
}