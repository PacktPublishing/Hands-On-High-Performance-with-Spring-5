package com.packt.springhighperformance.ch03.bankingapp.advisor;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.packt.springhighperformance.ch03.bankingapp.aspect.CustomPerformanceMonitorInterceptor;

public class CustomPerformanceMonitorAdvisor extends DefaultPointcutAdvisor {

	private static final long serialVersionUID = -3049371771366224728L;

	public CustomPerformanceMonitorAdvisor(CustomPerformanceMonitorInterceptor performanceMonitorInterceptor) {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(
				"com.packt.springhighperformance.ch03.bankingapp.aspect.TransferMonitoringAspect.transfer()");
		this.setPointcut(pointcut);
		this.setAdvice(performanceMonitorInterceptor);
	}
}
