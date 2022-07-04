package com.springbootwebservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootwebservice.entity.User;
import com.springbootwebservice.exception.ResourceNotFoundException;
import com.springbootwebservice.repo.UserRepo;
import com.springbootwebservice.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	private UserRepo userRepo;
	
	public UserServiceimpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@Override
	public User getUserById(long id) {
		//Optional<User> user = userRepo.findById(id);
		//if(user.isPresent()) {
		//return user.get();
		//}
		//else {
		//throw new ResourceNotFoundException("User", "ID", id);
		//}
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
	}



	@Override
	public User updateUser(User user, long id) {
		// we need to check whether user by given id is exist in database or not
		
		User existingUser = userRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id));
				
		existingUser.setUserName(user.getUserName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		
		//save existing user to database
				
		userRepo.save(existingUser);
				
		return existingUser;
		
	}


	@Override
	public void deleteUser(long id) {
		//check whether user is exist in database or not
		userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepo.deleteById(id);
		
	}


	
}
