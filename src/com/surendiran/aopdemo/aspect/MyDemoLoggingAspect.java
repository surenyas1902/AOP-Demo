package com.surendiran.aopdemo.aspect;

import com.surendiran.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());
    //
    @Around("execution(* com.surendiran.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint
    ) throws Throwable
    {
        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n==========>>> Executing @After on method: " + method);

        // get begin timestop
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception ex) {
            myLogger.warning(ex.getMessage());
            throw ex;
        }

        // get the timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=======> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }

    // Add a new advice for After
    @After("execution(* com.surendiran.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n==========>>> Executing @After on method: " + method);
    }

    // Add a new advice for @AfterReturning

    @AfterReturning(pointcut = "execution(* com.surendiran.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n==========>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        myLogger.info("\n==========>>> Result is " + result);
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
        myLogger.info("\n==========>>> Executing @AfterReturning on method: " + method);

        // log the exception
        myLogger.info("\n===========>>> Exception is " + myException);
    }

    @Before("com.surendiran.aopdemo.aspect.AOPExpressions.pointcutDeclarationExcludeGetSet()")
    public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
        myLogger.info("\n======>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinpoint.getSignature();

        myLogger.info("Method: " + methodSig);

        // get args
        Object[] args = theJoinpoint.getArgs();

        for(Object tempArg : args) {
            myLogger.info(tempArg.toString());
            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                myLogger.info("Account Name: " + theAccount.getName());
                myLogger.info("Accout level: " + theAccount.getLevel());
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
