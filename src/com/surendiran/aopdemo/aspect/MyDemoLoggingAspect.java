package com.surendiran.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // create a pointcut for setter methods

    // create point: include package... exclude getter/setter

    @Before("com.surendiran.aopdemo.aspect.AOPExpressions.pointcutDeclarationExcludeGetSet()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }

}
