package com.surendiran.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB Work: Adding an account");
    }
}
