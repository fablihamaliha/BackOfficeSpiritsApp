package com.cgi.AuthService.service;

import org.springframework.stereotype.Service;

import com.cgi.AuthService.exceptions.UserAlreadyExistsException;
import com.cgi.AuthService.exceptions.UserNotFoundException;
import com.cgi.AuthService.model.User;

import com.cgi.AuthService.exceptions.UserAlreadyExistsException;
import com.cgi.AuthService.model.User;

public interface UserAuthService {
	
	

    public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException;

    boolean saveUser(User user) throws UserAlreadyExistsException;
}
