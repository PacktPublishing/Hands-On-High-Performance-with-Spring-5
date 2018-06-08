package com.packt.springhighperformance.ch03.bankingapp.exception;

public class MinimumAmountException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MinimumAmountException(String message) {
		super(message);
	}

}
