package com.surendiran.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-4)
public class MyApiAnalyticsAspect {

    @Before("com.surendiran.aopdemo.aspect.AOPExpressions.pointcutDeclarationExcludeGetSet()")
    public void performApiAnalytics() {
        System.out.println("\n=====> Performing API Analytics");
    }
}
