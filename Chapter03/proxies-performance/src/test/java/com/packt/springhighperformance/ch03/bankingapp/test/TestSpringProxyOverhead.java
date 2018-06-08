package com.packt.springhighperformance.ch03.bankingapp.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.packt.springhighperformance.ch03.bankingapp.config.CGLIBProxyAppConfig;
import com.packt.springhighperformance.ch03.bankingapp.config.JDKProxyAppConfig;
import com.packt.springhighperformance.ch03.bankingapp.model.Account;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;
import com.packt.springhighperformance.ch03.bankingapp.service.Impl.TransferServiceImpl;

public class TestSpringProxyOverhead {

	private static final Logger LOGGER = Logger.getLogger(TestSpringProxyOverhead.class);

	@Test
	public void checkProxyPerformance() {
		int countofObjects = 3000;
		TransferServiceImpl[] unproxiedClasses = new TransferServiceImpl[countofObjects];
		for (int i = 0; i < countofObjects; i++) {
			unproxiedClasses[i] = new TransferServiceImpl();
		}

		TransferService[] cglibProxyClasses = new TransferService[countofObjects];
		TransferService transferService = null;
		for (int i = 0; i < countofObjects; i++) {
			transferService = new AnnotationConfigApplicationContext(CGLIBProxyAppConfig.class)
					.getBean(TransferService.class);
			cglibProxyClasses[i] = transferService;
		}

		TransferService[] jdkProxyClasses = new TransferService[countofObjects];
		for (int i = 0; i < countofObjects; i++) {
			transferService = new AnnotationConfigApplicationContext(JDKProxyAppConfig.class)
					.getBean(TransferService.class);
			jdkProxyClasses[i] = transferService;
		}

		long timeTookForUnproxiedObjects = invokeTargetObjects(countofObjects, unproxiedClasses);
		displayResults("Unproxied", timeTookForUnproxiedObjects);

		long timeTookForJdkProxiedObjects = invokeTargetObjects(countofObjects, jdkProxyClasses);
		displayResults("Proxy", timeTookForJdkProxiedObjects);

		long timeTookForCglibProxiedObjects = invokeTargetObjects(countofObjects, cglibProxyClasses);
		displayResults("cglib", timeTookForCglibProxiedObjects);

	}

	private void displayResults(String label, long timeTook) {
		LOGGER.info(label + ": " + timeTook + "(ns) " + (timeTook / 1000000) + "(ms)");
	}

	private long invokeTargetObjects(int countofObjects, TransferService[] classes) {
		long start = System.nanoTime();
		Account source = new Account(123456, "Account1");
		Account dest = new Account(987654, "Account2");
		for (int i = 0; i < countofObjects; i++) {
			classes[i].transfer(source, dest, 100);
		}
		long end = System.nanoTime();
		long execution = end - start;
		return execution;
	}
}
