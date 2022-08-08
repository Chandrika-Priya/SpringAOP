package com.practice.spring.dao;

import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

@Component
public class FortuneServiceDao {
    public void getFortune(){
        System.out.println("Expecting rain all day");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
