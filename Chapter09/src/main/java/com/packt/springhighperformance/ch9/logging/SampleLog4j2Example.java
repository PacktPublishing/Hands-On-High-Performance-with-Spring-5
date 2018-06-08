package com.packt.springhighperformance.ch9.logging;

import org.apache.log4j.Logger;

public class SampleLog4j2Example {
	private static Logger logger = Logger.getLogger(SampleLog4j2Example.class);

	public static void main(String argv[]) {
		logger.info("example info log");
		try {
			Bird.fly();
		} catch (Exception ex) {
			logger.error("example error log", ex);
		}
		logger.warn("example warning log");
	}
}