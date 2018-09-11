package com.spring.web.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indigo.dao.AuthDao;
import com.indigo.dao.entity.CustomerEntity;
import com.indigo.service.AuthService;
import com.spring.web.mvc.vo.ApplicationResponseVO;
import com.spring.web.mvc.vo.CustomerVO;
import com.spring.web.mvc.vo.Dog;

@Controller
public class CustomerJsonController {
	
	@Autowired
	@Qualifier("AuthServiceImpl")
	private AuthService authService;
	
	/*@PostConstruct
	public void  onlyOnce(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		authService=(AuthService)applicationContext.getBean("AuthServiceImpl");
	}*/
	
	 @PostMapping("/ajax-add-csutomer-as-json")
	 @ResponseBody	public ApplicationResponseVO registerUserPostJson(@RequestBody CustomerVO customerVO,Model model) {
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setStatus("success");
		authService.saveCustomer(customerVO);
		applicationResponseVO.setMessage("Hey you have registered successfully!");
		return applicationResponseVO;
	}
	
	
	//Since data from AJAX is coming as form so we can use @ModelAttribute
	@PostMapping("/ajax-add-csutomer")
	 @ResponseBody	public ApplicationResponseVO registerUserPost(@ModelAttribute CustomerVO customerVO,Model model) {
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setStatus("success");
		if(customerVO.getOperation().equals("add")){
			authService.saveCustomer(customerVO);
			applicationResponseVO.setMessage("Hey you have registered successfully!");
		}else if(customerVO.getOperation().equals("edit")){
			authService.updateCustomer(customerVO);
			applicationResponseVO.setMessage("Hey your reacord is updated successfully!");
		}
		
		
		
		return applicationResponseVO;
	}
	
	
			
	@GetMapping("/fecth-customer-by-username")
	@ResponseBody public CustomerVO loadCustomerByUsername(@RequestParam(value="username",required=false) String username,Model model) {
		CustomerVO customerVO=authService.findCustomerByUsername(username);
		return  customerVO;
	}			
	
	
	@GetMapping("/jdelete-customers")
	@ResponseBody public ApplicationResponseVO jdeleteCustomer(@RequestParam(value="username",required=false) String username,Model model) {
		authService.deleteCustomer(username);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setStatus("success");
		applicationResponseVO.setMessage("Hey customer is delete successfully! whose username is "+username);
		return applicationResponseVO;
	}
	
	
	@GetMapping("/jsearch-customers")
	@ResponseBody public List<CustomerVO> searchCustomers(@RequestParam(value="searchstring",required=false) String searchstring,Model model) {
		List<CustomerVO> customerList=new ArrayList<>();
		customerList=authService.searchCustomerByCriteria(searchstring);
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
	@ResponseBody public List<CustomerVO> showCustomer(@RequestParam(value="oowowow",required=false) String role,Model model) {
		List<CustomerVO> customerList=new ArrayList<>();
		if(role==null || role.equalsIgnoreCase("All")){
			customerList=authService.findCustomer();
		}else{
			customerList=authService.findCustomerByRole(role);
		}
		return customerList; //return java object instead of string
	}
	
}
