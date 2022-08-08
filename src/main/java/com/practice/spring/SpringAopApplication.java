package com.practice.spring;

import com.practice.spring.dao.AccountDao;
import com.practice.spring.dao.MembershipDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(springAOPconfig.class);
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        List<Account> accounts = null;

        try {
            accountDao.findAccounts(false);
        } catch (Exception e) {
            System.out.println("Exception caught in main program " + e);
        }

        System.out.println("after returning from method");

        System.out.println(accounts);
//		MembershipDao membershipDao = applicationContext.getBean("membershipDao",MembershipDao.class);
//		accountDao.addAccount();
//		accountDao.setName("Hello");
//		accountDao.setEmail("hello@gmail.com");
//		accountDao.getName();
//		accountDao.getEmail();
//		Account account = new Account();
//		account.setName("hello");
//		account.setLevel("1");
//		membershipDao.addAccount(account,true);
        applicationContext.close();
//		SpringApplication.run(SpringAopApplication.class, args);
    }

}
