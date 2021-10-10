package com.surendiran.aopdemo.aspect;

import com.surendiran.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // create a pointcut for setter methods

    // create point: include package... exclude getter/setter

    @Before("com.surendiran.aopdemo.aspect.AOPExpressions.pointcutDeclarationExcludeGetSet()")
    public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
        System.out.println("\n======>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinpoint.getSignature();

        System.out.println("Method: " + methodSig);

        // display method parameters

        // get args
        Object[] args = theJoinpoint.getArgs();

        for(Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Accout level: " + theAccount.getLevel());
            }
        }
    }

}
