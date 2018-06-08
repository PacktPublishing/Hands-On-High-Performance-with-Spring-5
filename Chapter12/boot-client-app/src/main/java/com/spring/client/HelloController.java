package com.spring.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello")
	public String hello() {
		ResponseEntity<String> response = this.restTemplate.exchange("http://BOOTEXAMPLE/welcome?name=World", HttpMethod.GET, null, String.class);
		return response.getBody();
	}

}
