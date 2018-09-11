package com.spring.soap.webservice;

import java.util.List;

import javax.jws.WebService;

import com.indigo.service.AuthService;
import com.spring.web.mvc.vo.CustomerVO;

@WebService
public class CustomerSoapWebService {
	
	
	/**
	 * We cannot use @Autowired because this class not a bean
	 * @return
	 */
	public List<CustomerVO> showCustomer(){
		AuthService authService=SpringRootWebContextUtils.getAuthService();
		List<CustomerVO> customerVOs=authService.findCustomer();
		return customerVOs;
	}
	
	/**
	 * We cannot use @Autowired because this class not a bean
	 * @return
	 */
	public String checkUsername(String username) throws Exception{
		if(username.endsWith("nagendra")){
			throw new Exception("This name is not allowed");
		}
		AuthService authService=SpringRootWebContextUtils.getAuthService();
		String result=authService.checkUsername(username);
		return result;
	}
	
	/**
	 * We cannot use @Autowired because this class not a bean
	 * @return
	 */
	public CustomerVO showCustomerByUsername(String username){
		AuthService authService=SpringRootWebContextUtils.getAuthService();
		CustomerVO customerVO=authService.findCustomerByUsername(username);
		return customerVO;
	}

}
