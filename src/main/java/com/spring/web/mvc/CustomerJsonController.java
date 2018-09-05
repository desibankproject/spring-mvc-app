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
import com.spring.web.mvc.vo.Dog;

@Controller
public class CustomerJsonController {
private AuthDao authDao;
	
	@PostConstruct
	public void  onlyOnce(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("auth-dao.xml");
	    authDao=(AuthDao)applicationContext.getBean("AuthDaoImpl");
	}
	
	
	@GetMapping("/jsearch-customers")
	@ResponseBody public List<CustomerEntity> searchCustomers(@RequestParam(value="searchstring",required=false) String searchstring,Model model) {
		List<CustomerEntity> customerList=new ArrayList<>();
		customerList=authDao.searchCustomerByCriteria(searchstring);
		return customerList;
	}
	
	@GetMapping("/jdog")
    @ResponseBody public Dog findDog(){
		Dog dog=new Dog();
		dog.setAge(12);
		dog.setColor("red");
		dog.setName("Packer");
		return dog;
		//in normal case we return string which is JSP
		//but here we are returning java object .....
		//so we should use @ResponseBody which will convert return Java Object into JSON using Jackson Mapper 
		//framework define inside pom.xml
	}
	
	@GetMapping("/jdogs")
    @ResponseBody public List<Dog> findDogs(){
		Dog dog1=new Dog();
		dog1.setAge(2);
		dog1.setColor("white");
		dog1.setName("Oqwiiw");
		
		Dog dog2=new Dog();
		dog2.setAge(4);
		dog2.setColor("brown");
		dog2.setName("Boro");
		
		Dog dog3=new Dog();
		dog3.setAge(12);
		dog3.setColor("red");
		dog3.setName("Packer");
		List<Dog> dogs=new ArrayList<>();
		dogs.add(dog3);
		dogs.add(dog2);
		dogs.add(dog1);
		//in normal case we return string which is JSP
		//but here we are returning java object .....
		//so we should use @ResponseBody which will convert return Java Object into JSON using Jackson Mapper 
		//framework define inside pom.xml
		return dogs;
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
