package com.packt.springhighperformance.ch03.bankingapp.interceptor;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class TransferInterceptor implements MethodBeforeAdvice{
	
	private static final Logger LOGGER = Logger.getLogger(TransferInterceptor.class);

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		LOGGER.info("transfer intercepted");
		
	}
}
