package com.user.entityDTO;



import com.user.entities.User;

public class UserDTO {

//	@Column(name = "EMAIL")
	private String email;
	
	private String name;
	
	private String mobileNumber;

	private String password;
	
	public UserDTO(String name, String email, String mobileNumber, String password) {
		super();
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
	
	public static User createUser(UserDTO userDTO) {
		return new User(userDTO.getName(),
				userDTO.getEmail(),
				userDTO.getMobileNumber(),
				userDTO.getPassword());
	}
	
}
