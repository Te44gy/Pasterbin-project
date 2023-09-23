package com.martin.pasterbin.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {

    @After("execution(* com.martin.pasterbin.service.ActiveUserService.setActiveUser(..))")
    public void afterSetUSerAdvice(){
        System.out.println("Активный пользователь установлен");
    }

    @After("execution(* com.martin.pasterbin.controllers.PostController.homePage())")
    public void beforeGetBookAdvice(){
        System.out.println("Произошел переход на главную страницу");
    }


    @Before("execution(* com.martin.pasterbin.service.ActiveUserService.setActiveUser(..))")
    public void beforeSetUserAdvice(){
        System.out.println("Активный пользователь установлен");
    }

}


