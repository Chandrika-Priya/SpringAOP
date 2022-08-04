package com.practice.spring.dao;

import com.practice.spring.Account;
import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public void addAccount(Account account){
        System.out.println(getClass()+" : adding account to db");
    }
}
