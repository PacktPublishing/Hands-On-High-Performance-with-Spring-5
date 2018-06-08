package com.packt.springhighperformance.ch03.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.packt.springhighperformance.ch03.bankingapp.advisor.CustomPerformanceMonitorAdvisor;
import com.packt.springhighperformance.ch03.bankingapp.aspect.CustomPerformanceMonitorInterceptor;
import com.packt.springhighperformance.ch03.bankingapp.aspect.TransferMonitoringAspect;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;
import com.packt.springhighperformance.ch03.bankingapp.service.impl.TransferServiceImpl;

@EnableAspectJAutoProxy
@Configuration
public class CustomPerformanceInterceptorAppConfig {
	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl();
	}

	@Bean
	public CustomPerformanceMonitorInterceptor customPerformanceMonitorInterceptor() {
		return new CustomPerformanceMonitorInterceptor(true);
	}

	@Bean
	public TransferMonitoringAspect transferAspect() {
		return new TransferMonitoringAspect();
	}

	@Bean
	public CustomPerformanceMonitorAdvisor customPerformanceMonitorAdvisor() {
		return new CustomPerformanceMonitorAdvisor(customPerformanceMonitorInterceptor());
	}
}
