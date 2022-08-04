package com.practice.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.practice.spring.aspect.PointCutExp.forDaoPackageExcludesGetSet()")
    public void beforeAccount(){
        System.out.println("executing before add account");
    }

}
