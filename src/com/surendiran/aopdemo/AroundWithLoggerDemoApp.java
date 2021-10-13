package com.surendiran.aopdemo;

import com.surendiran.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService fortuneService = annotationContext.getBean("trafficFortuneService",TrafficFortuneService.class);

        myLogger.info("\nMain Program: Around Demo App");

        boolean tripWire = true;
        String data = fortuneService.getFortune(tripWire);

        myLogger.info(data);

        // close the context
        annotationContext.close();
    }


}
