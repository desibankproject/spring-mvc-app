package com.spring.web.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indigo.service.AuthService;
import com.spring.web.mvc.vo.ApplicationResponseVO;
import com.spring.web.mvc.vo.CustomerVO;
import com.spring.web.mvc.vo.LoginVO;

//create bean
@Controller //this annotation says that it is acting as model ,action or controller
public class LoginController {
	
	
	@Autowired
	@Qualifier("AuthServiceImpl")
	private AuthService authService;
	
/*	
	@PostConstruct
	public void  onlyOnce(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		authService=(AuthService)applicationContext.getBean("AuthServiceImpl");
	}
*/	
	
	
	@GetMapping("/search-customer-home")
	 public String checkUsername() {
		return "customers-search";
	}
	
	@PostMapping("/ajax-validate-user")
	@ResponseBody public ApplicationResponseVO checkUserAjax(@ModelAttribute LoginVO loginVO,Model model) {
		LoginVO duser=authService.authUser(loginVO.getUsername(),loginVO.getPassword());
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		if(duser.getUsername()==null){
			applicationResponseVO.setStatus("fail");
			applicationResponseVO.setMessage("Hey your username and password are not valid ");
		}else{
			applicationResponseVO.setStatus("success");
			applicationResponseVO.setMessage("Wow");	
		}
		return applicationResponseVO;
	}
	
	
	@GetMapping("/checkUsername")
	@ResponseBody public String checkUsername(@RequestParam("purva") String purva,Model model) {
		String status=authService.checkUsername(purva);
		return status; //Here I want to send "yes" or no as it is to AJAX call 
		//@ResponseBody will by pass the view resolver and return value will be sent directly to the caller
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("pusername") String pusername,Model model) {
		//String username=request.getParameter("username"); = @RequestParam("pusername") String pusername
		authService.deleteCustomer(pusername);
		model.addAttribute("message", "Customer is delete from the database successfully!");
		List<CustomerVO> customerList=authService.findCustomer();
		model.addAttribute("customerList", customerList);
		return "customers";
	}
	
	
	@GetMapping("/search-customers")
	public String searchCustomers(@RequestParam(value="searchstring",required=false) String searchstring,Model model) {
		List<CustomerVO> customerList=new ArrayList<>();
		customerList=authService.searchCustomerByCriteria(searchstring);
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
		List<CustomerVO> customerList=new ArrayList<>();
		if(role==null || role.equalsIgnoreCase("All")){
			customerList=authService.findCustomer();
		}else{
			customerList=authService.findCustomerByRole(role);
		}
		model.addAttribute("customerList", customerList);
		return "customers";
	}
	
	@PostMapping("/register")
	public String registerUserPost(@ModelAttribute CustomerVO customerVO,Model model) {
		System.out.println("registerUserPost is called");
		System.out.println(customerVO);
		authService.saveCustomer(customerVO);
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
		
		LoginVO loginVO=authService.authUser(username, password);
		if(loginVO.getUsername()!=null) {
			request.setAttribute("message", "Hey you are a valid user and your role is "+loginVO.getRole());
		}else{
			request.setAttribute("message", "Sorry you are not a valid user..............");
		}
		return "status";  //status means  - status.jsp
	}

}
