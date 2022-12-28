package com.userservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.userservice.entity.User;
import com.userservice.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplementationTest {
	
	@InjectMocks
	private UserServiceImplementation userService;
	@Mock
	private UserRepository userRepo;

	@Test
	void testSaveUser() {
		User user=new User(5000l,"Laptop","rajashrre","routt","rajashreer@gmail.com","ctc","90877687","liza@123");
		
		Mockito.when(userRepo.save(user)).thenReturn(user);
		User actual=userService.saveUser(user);
		
		assertEquals(user, actual);	
	}

	@Test
	void testFindAll() {
		User u1 = new User(5000l,"Laptop","rajashrre","routt","rajashreer@gmail.com","ctc","90877687","liza@123");
		User u2 = new User(5000l,"Laptop","rajashrre","routt","rajashreer@gmail.com","ctc","90877687","liza@123");
		User u3 = new User(5000l,"Laptop","rajashrre","routt","rajashreer@gmail.com","ctc","90877687","liza@123");
		List<User> listOfUsers=new ArrayList<>();
		listOfUsers.add(u1);listOfUsers.add(u2);listOfUsers.add(u3);
		Mockito.when(userRepo.findAll()).thenReturn(listOfUsers);
		List<User> actuals=userService.findAll();
		assertEquals(listOfUsers, actuals);
		assertEquals(listOfUsers.size(), actuals.size());
		assertEquals(listOfUsers.get(0), actuals.get(0));
	}

}
