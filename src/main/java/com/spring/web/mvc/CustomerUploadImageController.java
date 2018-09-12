package com.spring.web.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.indigo.service.AuthService;
import com.spring.web.mvc.vo.CustomerVO;

@Controller
public class CustomerUploadImageController {

	@Autowired
	@Qualifier("AuthServiceImpl")
	private AuthService authService;
	
	//SPECIAL CODE WE ARE WRITTING HERE!@!!!!!!!!!!!!!!
	@GetMapping("/load-image")
	public void loadImage(@RequestParam("username") String username,HttpServletResponse response) throws IOException {
		byte[] image=authService.loadImageByUsername(username);
		response.setContentType("image/png");
		ServletOutputStream outputStream=response.getOutputStream();
		if(image!=null){
			outputStream.write(image);	
			outputStream.flush();
		}
	}
	/**
	 * 
	 * @param role 
	 * this role value would come from client
	 * required=false = means this value is optional
	 * @param model
	 * @return
	 */
	@GetMapping("/customers-with-image")
	public String showCustomer(Model model) {
		List<CustomerVO> customerList=new ArrayList<>();
		customerList=authService.findCustomerWithImage();
		model.addAttribute("customerList", customerList);
		return "customers-with-image";
	}

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
