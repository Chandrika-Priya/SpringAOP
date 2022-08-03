package com.practice.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public void addAccount(){
        System.out.println(getClass()+" : adding account to db");
    }
}
