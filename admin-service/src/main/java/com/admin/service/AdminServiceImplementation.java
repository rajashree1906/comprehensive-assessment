package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.admin.entity.Admin;
import com.admin.entity.Product;
import com.admin.entity.User;
import com.admin.repository.AdminRepository;
@Service

public class AdminServiceImplementation implements AdminService{
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override	
	public Admin fetchUserByUsername(String username,String password)
	{
	    return adminRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User saveUser(User user) {
		User u1=restTemplate.postForObject("http://localhost:8081/registeruser", user,User.class);
		return u1;
	}

	@Override
	public List<User> findAll() {
		List u = restTemplate.getForObject("http://localhost:8081/users", List.class);
		return u;
	}




	@Override
	public Product saveProduct(Product product) {
		Product p = restTemplate.postForObject("http://localhost:9008/v1/api/registerproduct", product, Product.class);
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List p1 = restTemplate.getForObject("http://localhost:9008/v1/api/products", List.class);
		return p1;
	}

	









	

}
