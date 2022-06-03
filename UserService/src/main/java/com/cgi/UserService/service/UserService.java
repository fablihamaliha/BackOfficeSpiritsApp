package com.cgi.UserService.service;



import java.util.List;

import com.cgi.UserService.exceptions.UserAlreadyExistsException;
import com.cgi.UserService.exceptions.UserProfileNotFoundException;
import com.cgi.UserService.exceptions.WarehouseAlreadyExistsException;
import com.cgi.UserService.model.userProfile;
import com.cgi.UserService.model.warehouse;

public interface UserService {
	public userProfile addUser(userProfile userProfile) throws UserAlreadyExistsException;
	public List<userProfile> getByUserName(String userName) throws UserProfileNotFoundException;
	public userProfile getUserByNameAndWarehouse(String userName, String warehouseid) throws UserProfileNotFoundException;
	public userProfile addWarehouseToUser(String userName, warehouse warehouse) throws UserProfileNotFoundException, WarehouseAlreadyExistsException;

}
