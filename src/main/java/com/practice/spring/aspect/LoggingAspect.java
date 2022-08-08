package com.practice.spring.aspect;

import com.practice.spring.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.practice.spring.aspect.PointCutExp.forDaoPackageExcludesGetSet()")
    public void beforeAccount(JoinPoint joinPoint){
        System.out.println("executing before add account");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature "+methodSignature);

        Object[] joinPointArgs = joinPoint.getArgs();

        for(Object obj : joinPointArgs){
            if(obj instanceof Account){
                Account account = (Account) obj;
                System.out.println(account.getName());
                System.out.println(account.getLevel());
            }
        }


    }

}
