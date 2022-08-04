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

    @Pointcut("execution(public * com.practice.spring.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(public * com.practice.spring.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("(forDaoPackage()  && !(getter() || setter()))")
    public void forDaoPackageExcludesGetSet(){}

    @Before("forDaoPackageExcludesGetSet()")
    public void beforeAccount(){
        System.out.println("executing before add account");
    }

    @Before("forDaoPackageExcludesGetSet()")
    public void performAPIAnalysis(){
        System.out.println("performing api analysis");
    }
}
