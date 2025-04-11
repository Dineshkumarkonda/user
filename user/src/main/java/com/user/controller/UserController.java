package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entityDTO.UserDTO;
import com.user.exceptions.UserServiceException;

import org.springframework.web.bind.annotation.RequestParam;
import com.user.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	public UserServiceImpl userImpl;

	@PostMapping(value = "/register")
	public ResponseEntity<String> getResponce(@RequestBody UserDTO user) throws UserServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(userImpl.Register(user));
	}

	@GetMapping(value = "/getUserDetails")
	public  ResponseEntity<UserDTO> getUserDetails(@RequestParam(name = "email") String email) throws UserServiceException {
		return  ResponseEntity.status(HttpStatus.OK).body(userImpl.getuserDetails(email));
	}
	@DeleteMapping(value="/deleteUser")
	public ResponseEntity<String> deleteuser(@RequestParam(name = "email") String email,@RequestParam(name = "password")String password) throws UserServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(userImpl.deleteUser(email,password));
	}
	
	@DeleteMapping(value="/deleteUserByEmail")
	public String deleteuserByEmail(@RequestParam(name = "email") String email,@RequestParam(name = "password")String password) throws UserServiceException {
		return userImpl.deleteUser(email,password);
	}
	
	@PostMapping(value="/updateUserDetails")
	public ResponseEntity<String> updateUserDetails(@RequestBody UserDTO UserDetails) throws UserServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(userImpl.updateuserDetails(UserDetails));
	}
	@GetMapping(value = "/getSuccess")
	public String getMesg() {
		return "Success";
	}
}
