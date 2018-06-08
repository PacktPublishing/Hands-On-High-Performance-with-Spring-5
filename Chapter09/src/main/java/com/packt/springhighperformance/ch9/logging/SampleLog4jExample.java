package com.packt.springhighperformance.ch9.logging;

import java.sql.Timestamp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class SampleLog4jExample {

	// Obtain a suitable logger.
	private static Logger logger = Logger.getLogger(SampleLog4jExample.class);

	public static void main(String argv[]) {
		Timestamp tOne = new Timestamp(System.currentTimeMillis());
		for(int i=0; i < 1000; i++) {
			logger.log(Level.WARN, "doing stuff");
		}
		Timestamp tTwo = new Timestamp(System.currentTimeMillis());
		System.out.println("Time:====> " + (tTwo.getTime() - tOne.getTime()));
		try {
			Bird.fly();
		} catch (Exception ex) {
			// Log the exception
			logger.log(Level.WARN, "trouble flying", ex);
		}
		logger.info("done");
	}
}
