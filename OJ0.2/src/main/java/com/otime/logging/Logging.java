package com.otime.logging;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	Logger logger = Logger.getRootLogger();
	public Logging() {
		System.out.println("Logging Constructor...");
	}
	
	@Pointcut("execution(* com.otime.core..*.*(..))")
	public void performance() {}
	
	@Before("performance()")
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		Object[] args = joinpoint.getArgs();
		logger.info("The method " + methodName + " start with " + Arrays.toString(args));
	}
	
	@After("performance()")
	public void after(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		logger.info("The method " + methodName + " end");
	}
	
	
}