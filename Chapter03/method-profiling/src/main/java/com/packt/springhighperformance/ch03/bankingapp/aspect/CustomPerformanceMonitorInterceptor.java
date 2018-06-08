package com.packt.springhighperformance.ch03.bankingapp.aspect;

import java.util.Date;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

public class CustomPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {
    
	private static final long serialVersionUID = -4060921270422590121L;

	public CustomPerformanceMonitorInterceptor() {
    }
 
    public CustomPerformanceMonitorInterceptor(boolean useDynamicLogger) {
            setUseDynamicLogger(useDynamicLogger);
    }
 
    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log log) 
      throws Throwable {
        String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        log.info("Method " + name + " execution started at:" + new Date());
        try {
            return invocation.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            log.info("Method "+name+" execution lasted:"+time+" ms");
            log.info("Method "+name+" execution ended at:"+new Date());
             
            if (time > 5){
                log.warn("Method execution took longer than 5 ms!");
            } 
        }
    }
}
