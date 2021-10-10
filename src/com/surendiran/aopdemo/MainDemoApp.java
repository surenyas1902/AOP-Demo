package com.surendiran.aopdemo;

import com.surendiran.aopdemo.dao.AccountDAO;
import com.surendiran.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = annotationContext.getBean("accountDAO",AccountDAO.class);

        MembershipDAO membershipDAO = annotationContext.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        membershipDAO.addAccount();

        membershipDAO.goToSleep();

        Account account = new Account();
        account.setName("Surendiran");
        account.setLevel("Level 1");
        // call the business method
        accountDAO.addAccount(account, true);

        System.out.println("For Getter and Setter process");

        accountDAO.setName("Surendiran");
        accountDAO.getServiceCode();

        // close the context
        annotationContext.close();
    }


}
