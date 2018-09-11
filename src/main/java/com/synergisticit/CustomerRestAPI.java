package com.synergisticit;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.indigo.service.AuthService;
import com.spring.soap.webservice.SpringRootWebContextUtils;
import com.spring.web.mvc.vo.CustomerVO;

@Path("v1") //Do not write / here
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRestAPI {
	
	
	//http://locahost:8080/spring-mvc-app/rest/v1/customers
	@GET
    @Path("/customers")
	public List<CustomerVO>  findCustomer() {
		AuthService authService=SpringRootWebContextUtils.getAuthService();
		List<CustomerVO> customerVOs=authService.findCustomer();
		return customerVOs;
	}

}
