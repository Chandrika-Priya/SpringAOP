package com.practice.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public void addAccount(){
        System.out.println(getClass()+": adding account to db");
    }
}
