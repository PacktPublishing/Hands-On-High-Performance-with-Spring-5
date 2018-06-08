package com.packt.springhighperformance.ch09.accountingclient;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AccountingServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountingServiceClientApplication.class, args);
	}
}

@RestController
class MainController {

	@Value("${accounting.service.url}")
	private String accountingServiceUrl;

	@GetMapping("/account")
	public String getAccountName(@RequestParam("id") Long id) {
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(accountingServiceUrl + "/" + id,
				String.class);
		JsonParser parser = new BasicJsonParser();
		Map<String, Object> responseMap = parser.parseMap(responseEntity.getBody());
		return (String) responseMap.get("accountName");
	}
}