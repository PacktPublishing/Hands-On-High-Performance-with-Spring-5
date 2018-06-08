package com.packt.springhighperformance.ch09.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	@ResponseBody
	public String helloWorld() {
		return "<h1>Hello World<h1>";
	}
	
	@RequestMapping(value="/welcome")
	@ResponseBody
	public String helloMessage(@RequestParam(name="name") String name) {
		return "<h1>Hello " +  name + "<h1>";
	}

}
