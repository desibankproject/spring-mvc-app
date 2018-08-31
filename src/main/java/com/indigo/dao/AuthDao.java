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

}
