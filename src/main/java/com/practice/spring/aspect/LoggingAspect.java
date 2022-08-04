package com.practice.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public * addAccount(com.practice.spring.Account,..))")
    public void beforeAccount(){
        System.out.println("executing before add account");
    }
}
