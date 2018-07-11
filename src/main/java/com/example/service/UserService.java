package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserModel;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(UserModel user)
	{
		userRepository.save(user);
	}

	public UserModel login(String email, String password) {
		return userRepository.findByEmailPassword(email,password);
	}
	
	public List<UserModel> getAllUser()
	{
		return userRepository.findAll();
	}
	
}
