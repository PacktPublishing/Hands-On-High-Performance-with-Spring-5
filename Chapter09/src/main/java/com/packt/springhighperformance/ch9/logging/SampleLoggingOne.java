package com.packt.springhighperformance.ch9.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SampleLoggingOne {
	// Obtain a suitable logger.
	private static Logger logger = Logger.getLogger("com.packt.springhighperformance.ch4.logging");

	public static void main(String argv[]) throws SecurityException, IOException {
		// Log a FINE tracing message
		/*
		 * Handler handlerObj = new ConsoleHandler();
		 * handlerObj.setLevel(Level.ALL); logger.addHandler(handlerObj);
		 * logger.setLevel(Level.ALL); logger.setUseParentHandlers(false);
		 */
		FileInputStream fis = new FileInputStream("D:\\projects\\spring-high-performance\\SampleProject\\src\\main\\resources\\logging.properties");
		LogManager.getLogManager().readConfiguration(fis);
		Timestamp tOne = new Timestamp(System.currentTimeMillis());
		for(int i=0; i < 100000; i++) {
			logger.fine("doing stuff");
		}
		Timestamp tTwo = new Timestamp(System.currentTimeMillis());
		System.out.println("Time: " + (tTwo.getTime() - tOne.getTime()));
		try {
			Bird.fly();
		} catch (Exception ex) {
			// Log the exception
			logger.log(Level.WARNING, "trouble flying", ex);
		}
		logger.fine("done");
	}
}
