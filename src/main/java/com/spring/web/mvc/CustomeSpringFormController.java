package com.spring.web.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.indigo.service.AuthService;
import com.spring.web.mvc.vo.CustomerVO;

@Controller
public class CustomeSpringFormController {
	
	@Autowired
	@Qualifier("AuthServiceImpl")
	private AuthService authService;
	
	@GetMapping("spring-form")
	public String showSpringRegistrationForm(Model model){
		//creating empty customer VO and adding into model means adding into request scope!
		CustomerVO customerVO=new CustomerVO();
		customerVO.setUsername("magicmagic");
		model.addAttribute("customerVO", customerVO);
		return "customer-form";
	}
	
	@PostMapping("sp-register")
	public String showSpringRegistrationFormPost(@ModelAttribute("customerVO") CustomerVO customerVO){
		//creating empty customer VO and adding into model means adding into request scope!
		System.out.println(customerVO);
		//Here we can call service layer to save data into the database
		return "customer-review-form";
	}
	
	
	
	@ModelAttribute("genderList")
	public List<String> populateGender(){
		List<String> genderList = new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Other");
		return genderList;
	}
	
	
	
	@ModelAttribute("roles")
	public List<String> populateRoles(){
		List<String> roles=new ArrayList<String>();
		roles.add("Customer");
		roles.add("Admin");
		roles.add("Employee");
		return roles;
	}
	
}
