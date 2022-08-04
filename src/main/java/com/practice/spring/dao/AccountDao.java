package com.practice.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    private String name;
    private String email;

    public String getName() {
        System.out.println(getClass()+" in getName()\n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" in setName()\n");
        this.name = name;
    }

    public String getEmail() {
        System.out.println(getClass()+" in getEmail()\n");
        return email;
    }

    public void setEmail(String email) {
        System.out.println(getClass()+" in setEmail()\n");
        this.email = email;
    }

    public void addAccount(){
        System.out.println(getClass()+" : adding account to db\n");
    }
    public void addAmount(){
        System.out.println(getClass()+" : adding amount to db\n");
    }
}
