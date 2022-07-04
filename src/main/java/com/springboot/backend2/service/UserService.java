package com.springbootwebservice.service;

import java.util.List;

import com.springbootwebservice.entity.User;

public interface UserService{
	
	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(long userId);
	
	User updateUser(User user, long id);

	void deleteUser(long id);
}
