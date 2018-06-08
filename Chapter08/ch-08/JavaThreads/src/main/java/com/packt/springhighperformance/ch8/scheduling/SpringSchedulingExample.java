package com.packt.springhighperformance.ch8.scheduling;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringSchedulingExample {
	private static final Logger LOGGER = Logger.getLogger(SpringSchedulingExample.class);

    @Scheduled(fixedDelay = 2000)
    public void scheduledTask() {
    	LOGGER.info("Execute task " + new Date());
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringSchedulingExample.class);
        String scheduledAnnotationProcessor = "org.springframework.context.annotation.internalScheduledAnnotationProcessor";
        LOGGER.info("ContainsBean :  " + scheduledAnnotationProcessor + ": "
                + context.containsBean(scheduledAnnotationProcessor));
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}