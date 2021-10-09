package com.surendiran.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

    @Pointcut("execution(* com.surendiran.aopdemo.dao.*.*(..))")
    public void forDaoPackage() { }

    // create a pointcut for getter methods
    @Pointcut("execution(* com.surendiran.aopdemo.dao.*.get*(..))")
    public void pointcutDeclarationForGetter() {}

    @Pointcut("execution(* com.surendiran.aopdemo.dao.*.set*(..))")
    public void pointcutDeclarationForSetter() {}

    @Pointcut("forDaoPackage() && !pointcutDeclarationForGetter() && !pointcutDeclarationForSetter()")
    public void pointcutDeclarationExcludeGetSet() {}
}
