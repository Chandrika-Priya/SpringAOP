package com.practice.spring.dao;

import com.practice.spring.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {
    private String name;
    private String email;

    public List<Account> findAccounts(boolean b) {
        if (b) {
            throw new RuntimeException("hi hello");
        }
        ArrayList<Account> accounts = new ArrayList<>();

        Account account1 = new Account("hello1", "1");
        Account account2 = new Account("hello2", "2");
        Account account3 = new Account("hello3", "3");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

    public String getName() {
        System.out.println(getClass() + " in getName()\n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " in setName()\n");
        this.name = name;
    }

    public String getEmail() {
        System.out.println(getClass() + " in getEmail()\n");
        return email;
    }

    public void setEmail(String email) {
        System.out.println(getClass() + " in setEmail()\n");
        this.email = email;
    }

    public void addAccount() {
        System.out.println(getClass() + " : adding account to db\n");
    }

    public void addAmount() {
        System.out.println(getClass() + " : adding amount to db\n");
    }
}
