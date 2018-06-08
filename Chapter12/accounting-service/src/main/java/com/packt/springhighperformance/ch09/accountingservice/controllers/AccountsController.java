package com.packt.springhighperformance.ch09.accountingservice.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
	@GetMapping(value = "/account/{name}")
	Map<String, Object> getAccount(@PathVariable String name) {
		return Collections.singletonMap("Account : ", name);
	}
}
