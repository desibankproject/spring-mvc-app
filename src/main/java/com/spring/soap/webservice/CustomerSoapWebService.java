package com.spring.soap.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indigo.service.AuthService;
import com.spring.web.mvc.vo.CustomerVO;

@WebService
public class CustomerSoapWebService {
	
	
	/**
	 * We cannot use @Autowired because this class not a bean
	 * @return
	 */
	public List<CustomerVO> showCustomer(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		AuthService authService=(AuthService)applicationContext.getBean("AuthServiceImpl");
		List<CustomerVO> customerVOs=authService.findCustomer();
		return customerVOs;
	}
	
	/**
	 * We cannot use @Autowired because this class not a bean
	 * @return
	 */
	public CustomerVO showCustomerByUsername(String username){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		AuthService authService=(AuthService)applicationContext.getBean("AuthServiceImpl");
		CustomerVO customerVO=authService.findCustomerByUsername(username);
		return customerVO;
	}

}
