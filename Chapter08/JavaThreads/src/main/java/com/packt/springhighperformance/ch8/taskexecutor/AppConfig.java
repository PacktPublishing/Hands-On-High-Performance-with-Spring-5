package com.packt.springhighperformance.ch8.taskexecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AppConfig {

	@Bean
	AsyncTask myBean() {
		return new AsyncTask();
	}

	@Bean
	AsyncTaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor t = new SimpleAsyncTaskExecutor();
		return t;
	}
}