package com.surendiran.aopdemo.aspect;

import com.surendiran.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // Add a new advice for After
    @After("execution(* com.surendiran.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n==========>>> Executing @After on method: " + method);
    }

    // Add a new advice for @AfterReturning

    @AfterReturning(pointcut = "execution(* com.surendiran.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n==========>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n==========>>> Result is " + result);
        if (!result.isEmpty()) {
            convertAccountNamesToUpperCase(result);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.surendiran.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "myException"
    )
    public void afterThrowingFindAccoutnsAdvice(JoinPoint theJoinPoint, Throwable myException) {

        // print which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n==========>>> Executing @AfterReturning on method: " + method);

        // log the exception
        System.out.println("\n===========>>> Exception is " + myException);
    }

    @Before("com.surendiran.aopdemo.aspect.AOPExpressions.pointcutDeclarationExcludeGetSet()")
    public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
        System.out.println("\n======>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinpoint.getSignature();

        System.out.println("Method: " + methodSig);

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

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account tempAccount : result) {
            String name = tempAccount.getName().toUpperCase();
            tempAccount.setName(name);
        }
    }

}
