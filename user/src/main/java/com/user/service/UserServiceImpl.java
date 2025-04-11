package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entities.User;
import com.user.entityDTO.UserDTO;
import com.user.exceptions.UserServiceException;
import com.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepo;

	@Override
	public String Register(UserDTO dto) throws UserServiceException {
		User newUser = UserDTO.createUser(dto);
		if (!userRepo.findById(dto.getEmail()).isPresent()) {
			userRepo.save(newUser);
			return "Sucefullly registered";
		}
		throw new UserServiceException("user already exit");
	}

	@Override
	public UserDTO getuserDetails(String email) throws UserServiceException {
		// TODO Auto-generated method stub
		Optional<User> details = userRepo.findById(email);
		if (details.isPresent()) {
			return User.createUserDTO(details.get());
		}
		throw new UserServiceException("user not found:");
	}

	@Override
	public String deleteUser(String email, String password) throws UserServiceException {
		UserDTO user = getuserDetails(email);
		if (user.getPassword().equals(password)) {
			userRepo.deleteById(email);
			return "Deleted Successfully";
		}
		throw new UserServiceException("invalid ID / password!");
	}

	@Override
	public String updateuserDetails(UserDTO dto) throws UserServiceException {
		UserDTO user = getuserDetails(dto.getEmail());
		if (user.getPassword().equals(dto.getPassword())) {
			userRepo.save(UserDTO.createUser(dto));
			return "User Details updated Succefully";
		}
		throw new UserServiceException("invalid password");
	}

}
