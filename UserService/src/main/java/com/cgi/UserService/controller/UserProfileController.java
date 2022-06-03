package com.cgi.UserService.controller;

import java.util.List;

import com.cgi.UserService.exceptions.WarehouseAlreadyExistsException;
import com.cgi.UserService.model.warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.cgi.UserService.exceptions.UserAlreadyExistsException;
import com.cgi.UserService.exceptions.UserProfileNotFoundException;
import com.cgi.UserService.model.userProfile;
import com.cgi.UserService.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/userProfile")
public class UserProfileController {
	 UserService userservice;
     @Autowired
	public UserProfileController(UserService userservice) {
		super();
		this.userservice = userservice;
	}
     
     
 	@PostMapping("/addUser")
 	public ResponseEntity<?> addUser(@RequestBody userProfile userProfile) 
 	{
 	
 	
 		try {
 			userProfile result=	userservice.addUser(userProfile);
 			return new ResponseEntity<userProfile>(result,HttpStatus.CREATED);
 		} catch (UserAlreadyExistsException e) {
 			return new ResponseEntity<String>("User aleady exist",HttpStatus.CONFLICT);
 		}
 		
 			
 	}
     @GetMapping("/{userName}/{warehouseId}")
	 public ResponseEntity<?> getUserNameAndWarehouse(@PathVariable("userName") String userName, @PathVariable() String warehouseId) 
		{
		
				try 
				{
				userProfile	user=userservice.getUserByNameAndWarehouse(userName, warehouseId);
					return new ResponseEntity<userProfile>(user,HttpStatus.OK);

				}catch(UserProfileNotFoundException e) {
					 return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
				}
				
			
			
		}
 	@GetMapping("/{userName}")
 	public ResponseEntity<?>getByUserName(@PathVariable String userName)
 	{
 		try {
 		List<userProfile>userProfile = userservice.getByUserName(userName);
 		if(userProfile !=null) {
 			return new ResponseEntity<List<userProfile>>(userProfile, HttpStatus.OK);
 		}
 		else {
 			return new ResponseEntity<String>("User doesnt exist", HttpStatus.NOT_FOUND);
 		}
 	}catch(UserProfileNotFoundException e) {
		 return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

}


	@PutMapping("/{userName}")
	public ResponseEntity<?> addWarehouseToUser(@PathVariable("userName") String userName, @RequestBody warehouse warehouse){

		 try{
			 userProfile user =  userservice.addWarehouseToUser(userName, warehouse);
			 return new ResponseEntity<userProfile>(user,HttpStatus.OK);
		 }catch(UserProfileNotFoundException e){
			 return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}catch(WarehouseAlreadyExistsException e){
			 return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		 }

	}
}
