package com.packt.springhighperformance.ch8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class ExecutorExample {
	private static final Logger LOGGER = Logger.getLogger(ExecutorExample.class);
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
 
        Runnable task = new Runnable() {
            public void run() {
            	LOGGER.info(Thread.currentThread().getName());
            }
        };
        
        /*Runnable task = () -> System.out.println(Thread.currentThread().getName());*/
 
        pool.execute(task);
 
        pool.shutdown();
    }
}