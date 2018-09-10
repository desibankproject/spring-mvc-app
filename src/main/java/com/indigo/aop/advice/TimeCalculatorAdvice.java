package com.indigo.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class TimeCalculatorAdvice {
	
	//execution(* com.indigo.dao.AuthDaoImpl.findCustomer())
	//execution(* com.indigo.dao.*.*(..))
	@Around("execution(* com.indigo.dao.AuthDaoImpl.findCustomer())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		long startTime=System.currentTimeMillis();
		String methodName=proceedingJoinPoint.getSignature().getName();
		Object value=null;
		//			//This code for before advice
		try {
			//hey go and call Actual method invocation
			value = proceedingJoinPoint.proceed();
			System.out.println("Return value from the method value = "+value);
		} catch (Throwable e) {
			//This code for throw advice
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Total time taken by method "+methodName+" is "+(endTime-startTime));
		//			//This code for after advice
		return value;
	}

}
