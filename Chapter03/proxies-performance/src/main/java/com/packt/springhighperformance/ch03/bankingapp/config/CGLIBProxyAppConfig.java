package com.packt.springhighperformance.ch03.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;
import com.packt.springhighperformance.ch03.bankingapp.service.Impl.TransferServiceImpl;

@EnableAspectJAutoProxy
@Configuration
public class CGLIBProxyAppConfig {

	@Bean
	@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
	public TransferService transferService(){
		return new TransferServiceImpl();
	}
}
