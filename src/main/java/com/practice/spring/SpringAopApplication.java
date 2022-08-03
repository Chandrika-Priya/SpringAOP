package com.practice.spring;

import com.practice.spring.dao.AccountDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(springAOPconfig.class);
		AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);
		accountDao.addAccount();
		applicationContext.close();
//		SpringApplication.run(SpringAopApplication.class, args);
	}

}
