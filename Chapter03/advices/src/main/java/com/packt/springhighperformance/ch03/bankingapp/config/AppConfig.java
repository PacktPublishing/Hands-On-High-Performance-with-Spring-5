package com.packt.springhighperformance.ch03.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.packt.springhighperformance.ch03.bankingapp.aspect.TransferServiceAspect;
import com.packt.springhighperformance.ch03.bankingapp.service.TransferService;
import com.packt.springhighperformance.ch03.bankingapp.service.Impl.TransferServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	public TransferService transferService(){
		return new TransferServiceImpl();
	}
	
	@Bean
	public TransferServiceAspect transferServiceAspect(){
		return new TransferServiceAspect();
	}
}
