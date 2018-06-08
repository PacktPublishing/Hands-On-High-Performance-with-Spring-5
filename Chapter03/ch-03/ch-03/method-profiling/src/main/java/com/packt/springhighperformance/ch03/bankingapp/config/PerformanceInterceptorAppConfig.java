package com.packt.springhighperformance.ch03.bankingapp.config;

import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.packt.springhighperformance.ch03.bankingapp.advisor.PerformanceMonitorAdvisor;
import com.packt.springhighperformance.ch03.bankingapp.aspect.TransferMonitoringAspect;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;
import com.packt.springhighperformance.ch03.bankingapp.service.impl.TransferServiceImpl;

@EnableAspectJAutoProxy
@Configuration
public class PerformanceInterceptorAppConfig {
	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl();
	}

	@Bean
	public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
		return new PerformanceMonitorInterceptor(true);
	}
	
	@Bean
	public TransferMonitoringAspect transferAspect() {
		return new TransferMonitoringAspect();
	}

	@Bean
	public PerformanceMonitorAdvisor performanceMonitorAdvisor() {
		return new PerformanceMonitorAdvisor(performanceMonitorInterceptor());
	}
}
