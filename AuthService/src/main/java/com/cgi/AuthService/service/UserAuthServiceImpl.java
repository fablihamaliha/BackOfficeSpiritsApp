package com.cgi.AuthService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.AuthService.exceptions.UserAlreadyExistsException;
import com.cgi.AuthService.exceptions.UserNotFoundException;
import com.cgi.AuthService.model.User;
import com.cgi.AuthService.repository.UserRepository;

@Service
public class UserAuthServiceImpl implements UserAuthService {

	private UserRepository userRepository;
    @Autowired 
 public UserAuthServiceImpl(UserRepository userRepository) {
	this.userRepository = userRepository;
}

	/*
	 * This method should be used to find an existing User with correct password.
	 */
   
   @Override
   public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException {
      User user = userRepository.findByUsernameAndPassword(username, password);
      if(user==null) {
   	   throw new UserNotFoundException("User not found");
      }
      return user;
   }

	/*
	 * This method should be used to save a new User.
	 */
   
   @Override
   public boolean saveUser(User user) throws UserAlreadyExistsException {
       Optional<User>user1 = userRepository.findById(user.getUsername());
       if(user1.isPresent()) {
       	throw new  UserAlreadyExistsException("User already exists");
       }
       userRepository.save(user);
       return true;
   }
	
	

}
