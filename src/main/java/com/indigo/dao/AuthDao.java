package com.indigo.dao;

import java.util.List;

import com.indigo.dao.entity.CustomerEntity;
import com.indigo.dao.entity.LoginEntity;

public interface AuthDao {

	LoginEntity authUser(String username, String password);

	String saveCustomer(CustomerEntity entity);

	List<CustomerEntity> findCustomer();

	String deleteCustomer(String username);

	String checkUsername(String username);

	List<CustomerEntity> findCustomerByRole(String role);


	CustomerEntity findCustomerByUsername(String username);

	List<CustomerEntity> searchCustomerByCriteria(String searchString);

	String updateCustomer(CustomerEntity entity);

	String saveCustomerWithImage(CustomerEntity entity);

	List<CustomerEntity> findCustomerWithImage();

	byte[] loadImageByUsername(String username);

}
