package com.indigo.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.indigo.dao.entity.CustomerEntity;
import com.indigo.dao.entity.LoginEntity;

//Dao means it contains database programming logic
//When ever you design business layer then we should design  interface also

@Repository("AuthDaoImpl")
@Scope("singleton")
public class AuthDaoImpl implements AuthDao {
	
	@Autowired
	@Qualifier("mjdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public String deleteCustomer(String username){
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(pdataSource);
		String sql="delete  from customers_tbl where username=?";
		int row=jdbcTemplate.update(sql,new Object[]{username});
		return row!=0?"success":"failure";
	}
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public String checkUsername(String username){
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(pdataSource);
		String sql="select * from customers_tbl where username=?";
		String status="yes";
		try {
			jdbcTemplate.queryForObject(sql,new Object[]{username},new BeanPropertyRowMapper(CustomerEntity.class));
		}catch(Exception ex){
			status="no";
		}
		return status;
	}
	
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public List<CustomerEntity> findCustomer(){
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(pdataSource);
		String sql="select * from customers_tbl";
		Timestamp doe=new Timestamp(new Date().getTime());
		List<CustomerEntity> customerEntities=jdbcTemplate.query(sql,new BeanPropertyRowMapper(CustomerEntity.class));
		return customerEntities;
	}
	
	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public String saveCustomer(CustomerEntity entity){
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(pdataSource);
		String sql="insert into customers_tbl(username,password,email,role,gender,photo,doe) values(?,?,?,?,?,?,?)";
		Timestamp doe=new Timestamp(new Date().getTime());
		Object data[]=new Object[]{entity.getUsername(), entity.getPassword(),entity.getEmail(),entity.getRole(),entity.getGender(),entity.getPhoto(),doe};
		jdbcTemplate.update(sql,data);
		return "success";
	}

	/**
	 * Code as per spring jdbc
	 * @param entity
	 * @return
	 */
	@Override
	public LoginEntity authUser(String username,String password){
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(pdataSource);
		String sql="select username,password,role from login_tbl where username=? and password=?";
		LoginEntity entity=null;
		try{
			entity=(LoginEntity)jdbcTemplate.queryForObject(sql,new Object[]{username,password}, new BeanPropertyRowMapper(LoginEntity.class));
		}catch(Exception exception){
			 entity=new LoginEntity();
			
		}
		return entity;
	}
	

}
