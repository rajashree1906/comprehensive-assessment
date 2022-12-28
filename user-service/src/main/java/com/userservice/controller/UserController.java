package com.userservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.userservice.entity.Product;
import com.userservice.entity.User;
import com.userservice.service.UserService;

import java.util.List;

@RestController

@CrossOrigin(origins="*")
public class UserController {
	
	Logger log=LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userservice;

 
  @PostMapping("/registeruser")
  public User saveUser(@RequestBody User user){
	  log.info("the post request is recieved"+user.getUsername());
	log.warn("the validation is wrong");
      return userservice.saveUser(user);
  }

  
  @PostMapping("/login")
  public User loginUser(@RequestBody User user) throws Exception
  {
      String username=user.getUsername();
      String password=user.getPassword();
      User userObj=null;
      if(username!=null&& password!=null)
      {
          userObj=userservice.fetchUserByUsername(username, password);
      }

      if(userObj==null)
      {
          throw new Exception("Bad credentials");
      }
      return userObj;

  }
  
  
  @GetMapping("/user/{id}")

  public Optional<User> userById(@PathVariable Long id){
      return userservice.userById(id);
  }
  
  

  @GetMapping("/name/{username}")
  public User findByusername(@PathVariable("username") String username) {
      return userservice.findByusername(username);
  }
  
  
	
	  @GetMapping("/users")
	 public List<User>findAllUser(){
		  log.info("The request came to the controller");
	  return userservice.findAll();
	}

  
  
  	@PutMapping("/update-user/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		return userservice.updateUser(id, userDetails);
	}


  @DeleteMapping("delete/{id}")
  public void deleteById(@PathVariable Long id) {
      
       userservice.deleteById(id);
  }
  
  @GetMapping("/user/showProducts")
	public List<Product> getAllProducts(){
		return userservice.getAllProducts();
	}
}
