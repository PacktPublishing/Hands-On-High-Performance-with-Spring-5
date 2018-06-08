package com.packt.springhighperformance.ch8.concurrent;

import java.util.concurrent.ThreadFactory;

import org.apache.log4j.Logger;

public class ThreadFactoryExample implements ThreadFactory {
	
	private static final Logger LOGGER = Logger.getLogger(ThreadFactoryExample.class);

	public static void main(String[] args) {
		ThreadFactoryExample factory = new ThreadFactoryExample();

		Runnable task = new Runnable() {
			public void run() {
				LOGGER.info(Thread.currentThread().getName());
			}
		};
		for (int i = 0; i < 5; i++) {
			Thread t = factory.newThread(task);
			t.start();
		}
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		return t;
	}
}