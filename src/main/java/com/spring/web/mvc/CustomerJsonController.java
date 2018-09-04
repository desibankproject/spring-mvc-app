package com.spring.web.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indigo.dao.AuthDao;
import com.indigo.dao.entity.CustomerEntity;

@Controller
public class CustomerJsonController {
private AuthDao authDao;
	
	
	@PostConstruct
	public void  onlyOnce(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("auth-dao.xml");
	    authDao=(AuthDao)applicationContext.getBean("AuthDaoImpl");
	}
	/**
	 * 
	 * @param role 
	 * this role value would come from client
	 * required=false = means this value is optional
	 * @param model
	 * @return
	 */
	@GetMapping("/customers-json")
	@ResponseBody public List<CustomerEntity> showCustomer(@RequestParam(value="oowowow",required=false) String role,Model model) {
		List<CustomerEntity> customerList=new ArrayList<>();
		if(role==null || role.equalsIgnoreCase("All")){
			customerList=authDao.findCustomer();
		}else{
			customerList=authDao.findCustomerByRole(role);
		}
		return customerList; //return java object instead of string
	}
	
}
