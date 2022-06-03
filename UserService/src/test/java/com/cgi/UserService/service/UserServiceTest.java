package com.cgi.UserService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cgi.UserService.repository.UserServiceRepo;
import com.cgi.UserService.exceptions.UserAlreadyExistsException;
import com.cgi.UserService.model.userProfile;
import com.cgi.UserService.model.warehouse;

public class UserServiceTest {
	@Mock
	private UserServiceRepo UserServiceRepo;
	
	@InjectMocks 
	private UserServiceImpl userService;
	
	private userProfile userProfile;
	private List<userProfile>userList;
	@BeforeEach
	 public void setUp(){

        MockitoAnnotations.initMocks(this);
        userList=new ArrayList<userProfile>();

        List<warehouse> warehouseList1 = new ArrayList<warehouse>();
        warehouse warehouse1 = new warehouse("213","Montreal");

        warehouseList1.add(warehouse1);

        userProfile = new userProfile("ABMT_2019",warehouseList1);
        userProfile user2 = new userProfile("ABM_4L",warehouseList1);

        userList.add(userProfile);
        userList.add(userProfile);
    }
	 @AfterEach
	    public void tearDown() throws Exception{
	        userList=null;
	        userProfile=null;
	    }
	 
	 @Test
	  public void testAddUser() throws UserAlreadyExistsException {
		 when(UserServiceRepo.save(userProfile)).thenReturn(userProfile);
		 userProfile userProfile1 = userService.addUser(userProfile);
		 assertEquals(userProfile, userProfile1);
		 
		 
		 
	 }
//	@Test
//	public void testGetByUserName() throws UserProfileNotFoundException {
//		when(userServiceRepo.findByUserName(any())).thenReturn(userList);
//		List<userProfile>userProfileList = userService.getByUserName("ABMT_2019");
//		assertEquals(userList, userProfileList);
//	}




	
	

}
