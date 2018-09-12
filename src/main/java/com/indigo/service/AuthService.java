package com.indigo.service;

import java.util.List;

import com.indigo.dao.entity.CustomerEntity;
import com.spring.web.mvc.vo.CustomerVO;
import com.spring.web.mvc.vo.LoginVO;

public interface AuthService {

	String deleteCustomer(String username);

	String checkUsername(String username);

	List<CustomerVO> findCustomer();

	List<CustomerVO> searchCustomerByCriteria(String searchString);

	List<CustomerVO> findCustomerByRole(String role);

	String saveCustomer(CustomerVO customerVO);

	LoginVO authUser(String username, String password);

	CustomerVO findCustomerByUsername(String username);

	String updateCustomer(CustomerVO customerVO);

	String saveCustomerWithImage(CustomerVO entity);

	List<CustomerVO> findCustomerWithImage();

	byte[] loadImageByUsername(String username);

}
