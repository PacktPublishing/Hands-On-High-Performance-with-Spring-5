package com.packt.springhighperformance.ch4.bankingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {

	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}
}

