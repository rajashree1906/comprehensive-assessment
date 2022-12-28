package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.Admin;
import com.admin.entity.Product;
import com.admin.entity.User;
import com.admin.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")

//@CrossOrigin(origins = "http://localhost:53850")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	 @PostMapping("/adminlogin")
	  public Admin loginAdmin(@RequestBody Admin admin) throws Exception
	  {
	      String username=admin.getUsername();
	      String password=admin.getPassword();
	      Admin adminObj=null;
	      if(username!=null&& password!=null)
	      {
	          adminObj=adminService.fetchUserByUsername(username, password);
	      }

	      if(adminObj==null)
	      {
	          throw new Exception("Bad credentials");
	      }
	      return adminObj;

	  }
	
	
	
	@PostMapping("/addUser")
	public User saveUser(@RequestBody User user) {
		return adminService.saveUser(user);
	}
	
	@GetMapping("/showUsers")
	public List<User>findAllUser(){
		return adminService.findAll();
	}
	
	@PostMapping("/addProduct")
	public Product saveProduct(@RequestBody Product product) {
		return adminService.saveProduct(product);
	}
	
	@GetMapping("/showProducts")
	public List<Product> getAllProducts(){
		return adminService.getAllProducts();
	}

}
