package com.surendiran.aopdemo;

import com.surendiran.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = annotationContext.getBean("accountDAO",AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = null;
        try {
            boolean tripWire = false;
            theAccounts = accountDAO.findAccounts(tripWire);
        }
        catch (Exception exc) {
            System.out.println("\n\nMain Program ... caught exceptions... " + exc);
        }

        // display the acounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");

        System.out.println("----------");
        System.out.println(theAccounts);
        System.out.println("\n");

        // close the context
        annotationContext.close();
    }


}
