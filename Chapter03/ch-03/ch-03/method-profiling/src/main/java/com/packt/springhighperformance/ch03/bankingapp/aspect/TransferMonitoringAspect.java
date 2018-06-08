package com.packt.springhighperformance.ch03.bankingapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect 
public class TransferMonitoringAspect {
	
	  @Pointcut("execution(* com.packt.springhighperformance.ch03.bankingapp.service.TransferService.transfer(..))")
	  public void transfer() { }
}
