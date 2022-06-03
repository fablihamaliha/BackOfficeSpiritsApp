package com.cgi.InventoryService.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    Logger logger= LoggerFactory.getLogger(LoggerAspect.class);
    @Pointcut("execution (* com.cgi.InventoryService.controller.*.*(..))")
    public void allFunctions(){}

    @AfterThrowing(pointcut= "allFunctions()", throwing = "e")
    public void afterThrowingAdvice(Exception e)
    {
        logger.info("Exception Raised: " +e.getMessage());
    }


}
