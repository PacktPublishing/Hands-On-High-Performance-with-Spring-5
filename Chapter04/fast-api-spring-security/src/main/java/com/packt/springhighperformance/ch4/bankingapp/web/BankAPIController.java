package com.packt.springhighperformance.ch4.bankingapp.web;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping(value="/secure")
public class BankAPIController {
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String home() {
		return "Welcome to the Bank";
	}

}
