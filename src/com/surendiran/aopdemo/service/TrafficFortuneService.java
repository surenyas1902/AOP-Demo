package com.surendiran.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Major Accident! Highway is closed");
        }
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        // return a fortune

        return "Service";
    }
}
