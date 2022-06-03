package com.cgi.UserService.controller;
import com.cgi.UserService.model.userProfile;
import com.cgi.UserService.model.warehouse;

import com.cgi.UserService.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cgi.UserService.exceptions.UserAlreadyExistsException;
import com.cgi.UserService.exceptions.UserProfileNotFoundException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc

public class UserServiceControllerTest {
     @Autowired
    private MockMvc mockMvc;
    private userProfile userProfile;
    private List<userProfile>userProfileList;
   
  
    @MockBean 
    private UserService userService;
    
    @InjectMocks 
    private UserProfileController userProfileController;
    
   

    
    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userProfileController).build();
        userProfileList = new ArrayList<userProfile>();
        List<warehouse> warehouseList1 = new ArrayList<warehouse>();
        warehouse warehouse1 = new warehouse("213","Montreal");

        warehouseList1.add(warehouse1);

        userProfile = new userProfile("ABMT_2019",warehouseList1);
        userProfile userProfile2 = new userProfile("ABM_4L",warehouseList1);

        userProfileList.add(userProfile);
        userProfileList.add(userProfile2);

  

   
    }
    @Test
    public void addUserSuccess() throws Exception {
    	
    	when(userService.addUser(any())).thenReturn(userProfile);
    	System.out.println("test.............");
		mockMvc.perform(post("/userProfile/addUser").contentType(MediaType.APPLICATION_JSON).content(asJsonString(userProfile)))
		.andExpect(status().isCreated());


    }
    @Test
    public void addUserFailure() throws Exception {
    	
    	when(userService.addUser(any())).thenThrow(UserAlreadyExistsException.class);
    	System.out.println("test.............");
		mockMvc.perform(post("/userProfile/addUser").contentType(MediaType.APPLICATION_JSON).content(asJsonString(userProfile)))
		.andExpect(status().isConflict());


    }
    
    
//    @Test
//  public void testGetUserByNameAndWarehouseSuccess() throws Exception {
//    	
//    	when(userService.getUserByNameAndWarehouse(product.get)).thenReturn(userProfile);
//    	System.out.println("test.............");
//		mockMvc.perform(get("/userProfile/{userName}/{warehouseid}", userProfile.getUserName(),warehouse.getWarehouseid())).andExpect(status().isOk());
//
//    }
//    @Test
//    public void testGetUserByNameAndWarehouseFailure() throws Exception {
//      	
//      	when(userService.getUserByNameAndWarehouse(userProfile.getUserName(), warehouse.getWarehouseid())).thenThrow(new UserProfileNotFoundException("Userprofile not found"));
//      	System.out.println("test.............");
//  		mockMvc.perform(get("/userProfile/user1/warehouse1")).andExpect(status().isNotFound());
//
//      }
    
    @Test 
    public void testGetUserByNameSuccess() throws Exception {
    	
        when(userService.getByUserName(any())).thenReturn(userProfileList);
   	mockMvc.perform(get("/userProfile/user")).andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
    	
    	
    }
    

    @Test 
   public void testGetUserByNameFailure() throws Exception {
  
    	 when(userService.getByUserName(any())).thenThrow(UserProfileNotFoundException.class);
   	
   	mockMvc.perform(get("/userProfile/userName")).andExpect(MockMvcResultMatchers.status().isNotFound())
    .andDo(MockMvcResultHandlers.print());
    	   }
    
    
    public static String asJsonString(final Object obj) {
        try {
        	ObjectMapper objmapper = new ObjectMapper();
        	objmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        	objmapper.registerModule(new JavaTimeModule());
            return objmapper.writeValueAsString(obj);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    


}
