package com.surendiran.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + ": Doing Stuff: Adding Membership account");
    }

    public void goToSleep() {
        System.out.println(getClass()+": I'm going to sleep now");
    }
}
