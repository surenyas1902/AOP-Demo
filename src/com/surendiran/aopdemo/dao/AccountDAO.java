package com.surendiran.aopdemo.dao;

import com.surendiran.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private String serviceCode;

    // add a new method: findAccounts()

    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("No soup for you!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account tempAcc1 = new Account("John", "Silver");
        Account tempAcc2 = new Account("Madhu", "Platinum");
        Account tempAcc3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(tempAcc1);
        myAccounts.add(tempAcc2);
        myAccounts.add(tempAcc3);

        return myAccounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account myAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB Work: Adding an account");
        doWork();
    }

    private boolean doWork() {
        System.out.println(getClass() + ": doWork() method");
        return false;
    }
}
