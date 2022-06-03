package com.cgi.UserService.exceptions;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String msg)
	{
		super (msg);
	}

}
