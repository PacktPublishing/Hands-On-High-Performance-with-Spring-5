package com.packt.springhighperformance.ch03.bankingapp.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.packt.springhighperformance.ch03.bankingapp.interceptor.TransferInterceptor;
import com.packt.springhighperformance.ch03.bankingapp.service.Impl.TransferServiceImpl;


@Configuration
public class ProxyFactoryBeanConfig {
	
	@Bean
	public Advisor transferServiceAdvisor() {
	    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	    pointcut.setExpression("execution(* com.packt.springhighperformance.ch03.bankingapp.service.TransferService.checkBalance(..))");
	    return new DefaultPointcutAdvisor(pointcut, new TransferInterceptor());
	}
	
	@Bean
	public ProxyFactoryBean transferService(){
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTarget(new TransferServiceImpl());
		proxyFactoryBean.addAdvisor(transferServiceAdvisor());
		proxyFactoryBean.setExposeProxy(true);
		return proxyFactoryBean;
	}
}
