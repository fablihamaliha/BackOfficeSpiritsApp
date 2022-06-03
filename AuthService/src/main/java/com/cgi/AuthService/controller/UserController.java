package com.cgi.AuthService.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.AuthService.exceptions.UserAlreadyExistsException;
import com.cgi.AuthService.exceptions.UserIdAndPasswordMismatchException;
import com.cgi.AuthService.model.User;
import com.cgi.AuthService.service.UserAuthService;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController 
@RequestMapping("/auth/api")
public class UserController {
	UserAuthService userAuthService;
	@Autowired 
	  public UserController(UserAuthService userAuthService) {
    	this.userAuthService = userAuthService;
	}
	
	 @PostMapping("/register")
	    public ResponseEntity<?> registerUser(@RequestBody User user) 
		{
		        try {
				userAuthService.saveUser(user);
				return new ResponseEntity<User>(user,HttpStatus.CREATED);
				
				}
		        catch(UserAlreadyExistsException e) {
		        	return new ResponseEntity<String>("User Already exists",HttpStatus.CONFLICT);
		        }
			
			     
		}
	@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) 
	{
    	

    	try {
    		User userre =userAuthService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) ;
    		if (userre != null) {
    			
    			 String mytoken=generateJWTToken(userre); 
   			   Map<String, String> response = new HashMap<>();
   			   response.put("token", mytoken);
   			   response.put("userName", user.getUsername());
   			  return new ResponseEntity<>(response,HttpStatus.OK);
    		}else {
    			
    		 throw new UserIdAndPasswordMismatchException("UserId and Password not matching");
    		}
    		}catch(Exception e) {
    			return new ResponseEntity<String>("Invalid username/password",HttpStatus.UNAUTHORIZED);
    		
    		}
	}
    
	
    public String generateJWTToken(User user)
    {
    	long expiry=100_000_000;
    	
    	return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
    											.setExpiration(new Date(System.currentTimeMillis()+ expiry ))
    											.signWith(SignatureAlgorithm.HS256, "cgicanadakey")
    											.compact();
    }
	
	
	
	

}
