package com.user.service;

import com.user.entityDTO.UserDTO;
import com.user.exceptions.UserServiceException;

public interface UserService {

	public String Register(UserDTO dto) throws UserServiceException;
	public UserDTO getuserDetails(String email) throws UserServiceException;
	public String deleteUser(String email, String password) throws UserServiceException;
	String updateuserDetails( UserDTO dto) throws UserServiceException;
	
}
