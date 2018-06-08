package com.packt.springhighperformance.ch8.concurrent;

import org.apache.log4j.Logger;

public class Task implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(Task.class);
	private String taskNumber;

	public Task(String taskNumber) {
		this.taskNumber = taskNumber;
	}

	@Override
	public void run() {
		LOGGER.info(Thread.currentThread().getName() + ", Execute Task = " + taskNumber);
		taskProcess();
		LOGGER.info(Thread.currentThread().getName() + ", End");
	}

	private void taskProcess() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}