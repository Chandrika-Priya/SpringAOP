package com.practice.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public int addAccount(){
        System.out.println(getClass()+" : adding account to db");
        return 1;
    }
}
