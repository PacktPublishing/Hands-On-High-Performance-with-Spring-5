package com.packt.springhighperformance.ch8.taskexecutor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskExecutorExample {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AsyncTask bean = context.getBean(AsyncTask.class);
		bean.runTasks();
	}
}