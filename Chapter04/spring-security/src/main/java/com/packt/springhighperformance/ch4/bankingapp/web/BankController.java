package com.packt.springhighperformance.ch4.bankingapp.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankController {
	
	@GetMapping("/")
	public ModelAndView home(Principal principal) {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome to Bank");
		model.addObject("message", "Hi " + principal.getName());
		model.setViewName("index");
		return model;

	}
	
	@GetMapping("/admin**")
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome to Admin Panel");
		model.addObject("message", "This is secured page - Admin Panel");
		model.setViewName("admin");

		return model;

	}
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
		}
		return "redirect:/login";
	}

}
