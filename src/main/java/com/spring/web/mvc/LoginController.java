package com.spring.web.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indigo.dao.AuthDao;
import com.indigo.dao.entity.CustomerEntity;
import com.indigo.dao.entity.LoginEntity;

//create bean
@Controller //this annotation says that it is acting as model ,action or controller
public class LoginController {
	
	private AuthDao authDao;
	
	
	
	
	@PostConstruct
	public void  onlyOnce(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("auth-dao.xml");
	    authDao=(AuthDao)applicationContext.getBean("AuthDaoImpl");
	}
	
	
	
	
	@GetMapping("/checkUsername")
	@ResponseBody public String checkUsername(@RequestParam("purva") String purva,Model model) {
		String status=authDao.checkUsername(purva);
		return status; //Here I want to send "yes" or no as it is to AJAX call 
		//@ResponseBody will by pass the view resolver and return value will be sent directly to the caller
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("pusername") String pusername,Model model) {
		//String username=request.getParameter("username"); = @RequestParam("pusername") String pusername
		authDao.deleteCustomer(pusername);
		model.addAttribute("message", "Customer is delete from the database successfully!");
		List<CustomerEntity> customerList=authDao.findCustomer();
		model.addAttribute("customerList", customerList);
		return "customers";
	}
	
	
	@GetMapping("/search-customers")
	public String searchCustomers(@RequestParam(value="searchstring",required=false) String searchstring,Model model) {
		List<CustomerEntity> customerList=new ArrayList<>();
		customerList=authDao.searchCustomerByCriteria(searchstring);
		model.addAttribute("customerList", customerList);
		return "customers";
	}
	
	/**
	 * 
	 * @param role 
	 * this role value would come from client
	 * required=false = means this value is optional
	 * @param model
	 * @return
	 */
	@GetMapping("/customers")
	public String showCustomer(@RequestParam(value="oowowow",required=false) String role,Model model) {
		List<CustomerEntity> customerList=new ArrayList<>();
		if(role==null || role.equalsIgnoreCase("All")){
			customerList=authDao.findCustomer();
		}else{
			customerList=authDao.findCustomerByRole(role);
		}
		model.addAttribute("customerList", customerList);
		return "customers";
	}
	
	@PostMapping("/register")
	public String registerUserPost(@ModelAttribute CustomerEntity customerEntity,Model model) {
		System.out.println("registerUserPost is called");
		System.out.println(customerEntity);
		authDao.saveCustomer(customerEntity);
		//List<CustomerEntity> customerList=authDao.findCustomer();
		//model.addAttribute("customerList", customerList);
		return "redirect:/customers?message=Customer is registered into the database successfully!";
	}
	
	@GetMapping("/register")
	public String registerUser(){
		return "customer-register";
	}
	
	@PostMapping("/auth")
	public String authUser(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginEntity entity=authDao.authUser(username, password);
		if(entity.getUsername()!=null) {
			request.setAttribute("message", "Hey you are a valid user and your role is "+entity.getRole());
		}else{
			request.setAttribute("message", "Sorry you are not a valid user..............");
		}
		return "status";  //status means  - status.jsp
	}

}
