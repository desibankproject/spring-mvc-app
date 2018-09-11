package com.spring.soap.webservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indigo.service.AuthService;

public class SpringRootWebContextUtils {
	
	private static ApplicationContext applicationContext;
	
	static{
		 applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public  static 	AuthService getAuthService(){
		AuthService authService=(AuthService)applicationContext.getBean("AuthServiceImpl");	
		return authService;
	}
	

}
