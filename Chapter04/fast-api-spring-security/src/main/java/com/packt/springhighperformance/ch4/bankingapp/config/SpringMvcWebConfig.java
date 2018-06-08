package com.packt.springhighperformance.ch4.bankingapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.packt.springhighperformance.ch4.bankingapp"})
public class SpringMvcWebConfig implements WebMvcConfigurer {
	
}
