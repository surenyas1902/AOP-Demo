package com.surendiran.aopdemo.dao;

import com.surendiran.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account myAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB Work: Adding an account");
        doWork();
    }

    private boolean doWork() {
        System.out.println(getClass() + ": doWork() method");
        return false;
    }
}
