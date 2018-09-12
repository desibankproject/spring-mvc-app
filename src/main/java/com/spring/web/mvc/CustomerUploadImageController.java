package com.spring.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.indigo.service.AuthService;
import com.spring.web.mvc.vo.CustomerVO;

@Controller
public class CustomerUploadImageController {

	@Autowired
	@Qualifier("AuthServiceImpl")
	private AuthService authService;

	@PostMapping("/register-with-image")
	public String registerUserPost(@ModelAttribute CustomerVO customerVO, Model model) {
		System.out.println("registerUserPost is called");
		System.out.println(customerVO);
		authService.saveCustomerWithImage(customerVO);
		// List<CustomerEntity> customerList=authDao.findCustomer();
		// model.addAttribute("customerList", customerList);
		return "redirect:/customers?message=Customer is registered into the database successfully!";
	}

	// It converts your upload file into byte array form after it
	// it is populated in customer java object

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
	}

}
