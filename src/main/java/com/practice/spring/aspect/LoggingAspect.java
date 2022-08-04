package com.practice.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(public * com.practice.spring.dao.*.*(..))")
    public void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAccount(){
        System.out.println("executing before add account");
    }

    @Before("forDaoPackage()")
    public void performAPIAnalysis(){
        System.out.println("performing api analysis");
    }
}
