package com.surendiran.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Exeucting @Before advice on addAccount()");
    }

    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice1()
    {
        System.out.println("\nExecuting @Before 2");
    }
}
