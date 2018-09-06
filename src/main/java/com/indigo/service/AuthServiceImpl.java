package com.indigo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indigo.dao.AuthDao;
import com.indigo.dao.entity.CustomerEntity;
import com.indigo.dao.entity.LoginEntity;
import com.spring.web.mvc.vo.CustomerVO;
import com.spring.web.mvc.vo.LoginVO;


@Service("AuthServiceImpl")
public class AuthServiceImpl implements AuthService {
	
	
	@Autowired
	@Qualifier("AuthDaoImpl")
	private AuthDao authDao;
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public String deleteCustomer(String username){
		return authDao.deleteCustomer(username);
	}
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public String checkUsername(String username){
		 return authDao.checkUsername(username);
	}
	
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public List<CustomerVO> findCustomer(){
		List<CustomerEntity> customerEntities=authDao.findCustomer();
		//write code for conversion from List<CustomerEntity> into List<CustomerVO>
		List<CustomerVO> customerVOs=new ArrayList<>();
		for (CustomerEntity entity : customerEntities) {
			CustomerVO customerVO=new CustomerVO();
			BeanUtils.copyProperties(entity, customerVO);
			customerVOs.add(customerVO);
		}
		return customerVOs;
	}
	
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public List<CustomerVO> searchCustomerByCriteria(String searchString){
		List<CustomerEntity> customerEntities=authDao.searchCustomerByCriteria(searchString);
		List<CustomerVO> customerVOs=new ArrayList<>();
		for (CustomerEntity entity : customerEntities) {
			CustomerVO customerVO=new CustomerVO();
			BeanUtils.copyProperties(entity, customerVO);
			customerVOs.add(customerVO);
		}
		return customerVOs;
	}
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public List<CustomerVO> findCustomerByRole(String role){
		List<CustomerEntity> customerEntities=authDao.findCustomerByRole(role);
		List<CustomerVO> customerVOs=new ArrayList<>();
		for (CustomerEntity entity : customerEntities) {
			CustomerVO customerVO=new CustomerVO();
			BeanUtils.copyProperties(entity, customerVO);
			customerVOs.add(customerVO);
		}
		return customerVOs;
	}
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	@Transactional
	public String saveCustomer(CustomerVO customerVO){
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(pdataSource);
		CustomerEntity entity=new CustomerEntity();
		BeanUtils.copyProperties(customerVO, entity);
		String result=authDao.saveCustomer(entity);
		return result;
	}

	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public LoginVO authUser(String username,String password){
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(pdataSource);
		LoginEntity loginEntity=authDao.authUser(username, password);
		LoginVO loginVO=new LoginVO();
		BeanUtils.copyProperties(loginEntity,loginVO);
		return loginVO;
	}

}
