package com.surendiran.aopdemo;

import com.surendiran.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService fortuneService = annotationContext.getBean("trafficFortuneService",TrafficFortuneService.class);

        System.out.println("\nMain Program: Around Demo App");

        boolean tripWire = true;
        String data = fortuneService.getFortune(tripWire);

        System.out.println(data);

        // close the context
        annotationContext.close();
    }


}
