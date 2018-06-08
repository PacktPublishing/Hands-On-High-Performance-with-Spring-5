package com.springhighperformance.jmx;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport
public class JmxSpringMain {
	private static final Random rand = new Random();
	
    @Bean
    public Resource jmxResource() {
        return new Resource();
    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(JmxSpringMain.class);
        do {
	        Calculator cal = context.getBean(Calculator.class);
	        cal.calculate(rand.nextInt(), rand.nextInt());
	        Thread.sleep(Long.MAX_VALUE);
        } while(true);
    }
}