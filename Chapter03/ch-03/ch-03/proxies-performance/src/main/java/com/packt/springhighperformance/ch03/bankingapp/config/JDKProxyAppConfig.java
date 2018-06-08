package com.packt.springhighperformance.ch03.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;
import com.packt.springhighperformance.ch03.bankingapp.service.Impl.TransferServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class JDKProxyAppConfig {

	@Bean
	@Scope(proxyMode=ScopedProxyMode.INTERFACES)
	public TransferService transferService(){
		return new TransferServiceImpl();
	}
}
