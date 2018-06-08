package com.packt.springhighperformance.ch8.taskexecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import com.packt.springhighperformance.ch8.concurrent.Task;

public class AsyncTask {
	@Autowired
	private AsyncTaskExecutor executor;

	public void runTasks() throws Exception {

		for (int i = 1; i <= 5; i++) {
			Runnable task = new Task(" " + i);
			executor.execute(task);
		}
	}

}
