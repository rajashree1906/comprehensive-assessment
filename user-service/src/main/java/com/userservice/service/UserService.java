package com.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.userservice.entity.Product;
import com.userservice.entity.User;

public interface UserService {

	public User saveUser(User user);

	public User fetchUserByUsername(String username, String password);

	public Optional<User> userById(Long id);

	public List<User> findAll();
	
	public User updateUser(Long id, User userDetails);


	public void deleteById(Long id);
	
	
	public List<Product> getAllProducts();

	public User findByusername(String username);

}
