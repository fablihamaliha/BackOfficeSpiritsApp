package com.cgi.AuthService.aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;

/* Annotate this class with @Aspect and @Component */
@Aspect
@Component
public class LoggerAspect {

//	Logger mylog=LoggerFactory.getLogger(this.getClass());
//	/*
//	 * Write loggers for each of the methods of NewsController, any particular method
//	 * will have all the four aspectJ annotation
//	 * (@Before, @After, @AfterReturning, @AfterThrowing).
//	 */
//
//	@Before("execution (* com.stackroute.user.controller.UserController.saveUser(..))")
//	public void loginBeforeSveUser(JoinPoint jp)
//	{
//		mylog.info("saveUser method is called", jp);
//	}
//	@After("execution (* com.stackroute.user.controller.UserController.saveUser(..))")
//	public void logAfterSveUser(JoinPoint jp) {
//		mylog.info("After method ended", jp);
//	}
//	@AfterReturning("execution (* com.stackroute.user.controller.UserController.saveUser(..))")
//	public void logAfterReturningSaveUser(JoinPoint jp) {
//		mylog.info("method is running",jp );
//
//	}
//	@AfterThrowing(pointcut="execution (* com.stackroute.user.controller.UserController.saveUser(..))",throwing="exception")
//	public void logAfterThrowingSveUser( Exception exception)
//	{
//		mylog.warn("exception is raised while adding user " + exception.getMessage());
//	}
//
//
	
	

}
