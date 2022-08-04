package com.practice.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogInCloudAspect {
    @Before("com.practice.spring.aspect.PointCutExp.forDaoPackageExcludesGetSet()")
    public void logInCloudSync() {
        System.out.println("performing logging to cloud sync");
    }
}
