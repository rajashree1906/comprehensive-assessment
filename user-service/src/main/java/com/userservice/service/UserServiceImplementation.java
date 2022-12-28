package com.userservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.userservice.entity.Product;
import com.userservice.entity.User;
import com.userservice.exception.UserNotFoundException;
import com.userservice.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	Logger log=LoggerFactory.getLogger(UserServiceImplementation.class);

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		
		User u= userRepo.save(user);
		
		if(u==null) {
			log.warn("The user object is not save in the db");
			
		}
		return u;
	}

	@Override
	public User fetchUserByUsername(String username, String password) {
		return userRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public Optional<User> userById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override

	public List<User> findAll() {
		List<User> list = userRepo.findAll(); 
		if(list.isEmpty()) {
			log.error("No user details in the db");
			log.debug("the list of user is"+list.size());
		}
		log.info("fetched some user"+list.size());
		return list;
		
	}

	
	@Override
	public User updateUser(Long id, User userDetails) {
		User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));

		user.setId(userDetails.getId());
		user.setUsername(userDetails.getUsername());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setPassword(userDetails.getPassword());
		user.setEmailId(userDetails.getEmailId());
		user.setContactNumber(userDetails.getContactNumber());
		user.setAddress(userDetails.getAddress());

		User updatedUser = userRepo.save(user);

		return updatedUser;
	}

	@Override

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
//		 return "Customer :" + c_id + " : Deleted successfully";
		// return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List p1 = restTemplate.getForObject("http://localhost:9008/v1/api/products", List.class);
		return p1;
	}

	@Override
	public User findByusername(String username) {

		return userRepo.findByUsername(username);
	}

	// @Override
//	public User updateUserById(User update) {
//	    // TODO Auto-generated method stub
//	     User existingUser = userRepo.findById(update.getUser_id()).orElse(null);
//	        existingUser.setUsername(update.getUsername());
//	        existingUser.setEmailId(update.getEmailId());
//	        existingUser.setPassword(update.getPassword());
//	        existingUser.setAddress(update.getAddress());
//	        existingUser.setContactNumber(update.getContactNumber());
//	        return userRepo.save(existingUser);
//
//
//
//	}

}
