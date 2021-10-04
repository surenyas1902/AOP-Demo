package com.surendiran.aopdemo;

import com.surendiran.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = annotationContext.getBean("accountDAO",AccountDAO.class);

        // call the business method
        accountDAO.addAccount();

        // close the context
        annotationContext.close();
    }
}
