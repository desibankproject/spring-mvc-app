package com.indigo.aop.advice;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class TimerAdvice {
	
	//Here write common code which you want to inject before every method
		@Before("execution(* com.indigo.dao.*.*(..))")
		public void messageLogger(JoinPoint joinPoint) {
			System.out.println("Name of the method which is invoked......" + joinPoint.getSignature().getName());
			System.out.println("******>>> Method inputs are - "+Arrays.asList(joinPoint.getArgs()));
			System.out.println("Hey this is method is called at "+new Date());
		}

}
