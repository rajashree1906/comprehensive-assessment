package com.admin.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.admin.entity.Admin;
import com.admin.entity.Product;
import com.admin.entity.User;


public interface AdminService {
	
	public Admin fetchUserByUsername(String username, String password);
	
	
	public User saveUser(User user);

	public Product saveProduct(Product product);


	public List<User> findAll();
	
	public List<Product> getAllProducts();
	
	
}
