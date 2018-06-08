package com.packt.springhighperformance.ch8.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
@Configuration
@EnableAsync
public class AppConfig {
	@Bean
	public AsyncTask asyncTask() {
		return new AsyncTask();
	}
}