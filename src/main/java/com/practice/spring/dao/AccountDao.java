package com.practice.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public void addAccount(){
        System.out.println(getClass()+" : adding account to db");
    }
    public void addAmount(){
        System.out.println(getClass()+" : adding amount to db");
    }
}
