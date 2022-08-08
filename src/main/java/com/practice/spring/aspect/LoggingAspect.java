package com.practice.spring.aspect;

import com.practice.spring.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @AfterReturning(pointcut="execution(* com.practice.spring.dao.AccountDao.findAccounts(..))",returning = "accounts")
    public void afterReturningFindAccount(JoinPoint joinPoint, List<Account> accounts){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("After Execution "+methodSignature.toShortString());
        for(Account account: accounts){
            account.setName(account.getName().toUpperCase());
        }
        System.out.println("the result "+ accounts);
    }

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
