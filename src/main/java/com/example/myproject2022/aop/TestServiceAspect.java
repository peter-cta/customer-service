package com.example.myproject2022.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class TestServiceAspect {
    private Logger logger = LoggerFactory.getLogger(TestServiceAspect.class);

    @Before("execution(* com.example.myproject2022.controller.impl.AdminUserControllerImpl.getAllUsers(..))")
    private void before(JoinPoint joinPoint) {
        logger.info("Before called" + joinPoint.toString());
    }

}
