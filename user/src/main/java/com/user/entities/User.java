package com.user.entities;


import com.user.entityDTO.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@Column(name = "EMAIL")
	private String email;
	
	private String name;
	
//	@Column(name = "mobile_number")
	private String mobileNumber;

	private String password;
	
	public User() {
		super();
	}
	
	public User(String name, String email, String mobileNumber, String password) {
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public static UserDTO createUserDTO(User user) {
		return new UserDTO(user.getName(),
				user.getEmail(),
				user.getMobileNumber(),
				user.getPassword());
	}
	
}
