package com.packt.springhighperformance.ch03.bankingapp.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.packt.springhighperformance.ch03.bankingapp.exception.MinimumAmountException;
import com.packt.springhighperformance.ch03.bankingapp.model.Account;

@Aspect
public class TransferServiceAspect {

	private static final Logger LOGGER = Logger.getLogger(TransferServiceAspect.class);

	@Pointcut("execution(* com.packt.springhighperformance.ch03.bankingapp.service.TransferService.transfer(..))")
	public void transfer() {}

	@Before("transfer()")
	public void beforeTransfer(JoinPoint joinPoint) {
		LOGGER.info("validate account balance before transferring amount");
	}

	@After("transfer()")
	public void afterTransfer(JoinPoint joinPoint) {
		LOGGER.info("Sucessfully transferred from source account to dest account");
	}

	@AfterReturning(pointcut = "transfer() and args(source, dest, amount)", returning = "isTransferSucessful")
	public void afterTransferReturns(JoinPoint joinPoint, Account source, Account dest, Double amount,
			boolean isTransferSucessful) {
		if (isTransferSucessful) {
			LOGGER.info("Amount transferred successfully ");
			// find remaining balance of source account
		}
	}
	
	@AfterThrowing(pointcut = "transfer()", throwing = "minimumAmountException")
	public void exceptionFromTransfer(JoinPoint joinPoint, MinimumAmountException minimumAmountException) {
		LOGGER.info("Exception thrown from transfer method: " + minimumAmountException.getMessage());
	}
	
	@Around("transfer()")
	public boolean aroundTransfer(ProceedingJoinPoint proceedingJoinPoint){
		LOGGER.info("Inside Around advice, before calling transfer method ");
		boolean isTransferSuccessful = false;
		try {
			isTransferSuccessful = (Boolean)proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info("Inside Around advice, after returning from transfer method");
		return isTransferSuccessful;
	}
}
