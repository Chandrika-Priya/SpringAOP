package com.practice.spring.dao;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class FortuneServiceDao {
    public String getFortune(){
        System.out.println("Expecting rain all day");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFortune(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("Error");
        }
        return getFortune();
    }
}
