package com.spring.web.mvc.vo;

import java.util.Date;

public class CustomerVO {
	private String username;
	private String password;
	private String role;
	private String gender;
	private String operation; 
	private String email;
	private String photo;
	private Date doe;
	private byte[] image;
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "CustomerVO [username=" + username + ", password=" + password + ", role=" + role + ", gender="
				+ gender + ", email=" + email + ", photo=" + photo + ", doe=" + doe + "]";
	}

}
