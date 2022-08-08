package com.practice.spring.aspect;

import com.practice.spring.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Around("execution(* com.practice.spring.dao.FortuneServiceDao.getFortune())")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end= System.currentTimeMillis();
        System.out.println("in around "+(end-begin));
        return  object;
    }

    @After("execution(* com.practice.spring.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccount(JoinPoint joinPoint){
        System.out.println("Executing after finally ");
    }

    @AfterThrowing(pointcut = "execution(* com.practice.spring.dao.AccountDao.findAccounts(..))", throwing = "exec")
    public void afterThrowingException(JoinPoint joinPoint, Throwable exec) {
        System.out.println("Execution in logging Aspect " + exec);
    }

    @AfterReturning(pointcut = "execution(* com.practice.spring.dao.AccountDao.findAccounts(..))", returning = "accounts")
    public void afterReturningFindAccount(JoinPoint joinPoint, List<Account> accounts) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("After Execution " + methodSignature.toShortString());
        for (Account account : accounts) {
            account.setName(account.getName().toUpperCase());
        }
        System.out.println("the result " + accounts);
    }

    @Before("com.practice.spring.aspect.PointCutExp.forDaoPackageExcludesGetSet()")
    public void beforeAccount(JoinPoint joinPoint) {
        System.out.println("executing before add account");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature " + methodSignature);

        Object[] joinPointArgs = joinPoint.getArgs();

        for (Object obj : joinPointArgs) {
            if (obj instanceof Account) {
                Account account = (Account) obj;
                System.out.println(account.getName());
                System.out.println(account.getLevel());
            }
        }


    }

}
