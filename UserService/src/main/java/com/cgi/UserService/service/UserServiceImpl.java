package com.cgi.UserService.service;

import java.util.List;
import java.util.Optional;

import com.cgi.UserService.exceptions.WarehouseAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cgi.UserService.exceptions.UserAlreadyExistsException;
import com.cgi.UserService.exceptions.UserProfileNotFoundException;
import com.cgi.UserService.model.userProfile;
import com.cgi.UserService.model.warehouse;
import com.cgi.UserService.repository.UserServiceRepo;


@Service
public class UserServiceImpl implements UserService {
	UserServiceRepo UserServiceRepo;
	@Autowired
	public UserServiceImpl(UserServiceRepo UserServiceRepo) {
		this.UserServiceRepo = UserServiceRepo;
	}
	@Override
	public userProfile addUser(userProfile userProfile) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub

		userProfile result=null;
		Optional<userProfile> opt=UserServiceRepo.findById(userProfile.getUserName());
		List<warehouse> warehouses=userProfile.getWarehouses();
		
		 warehouse first=warehouses.stream().findFirst().get();
		 
        	if (opt.isPresent())
			{
			  userProfile inexist=opt.get();
			  List<warehouse> ewarehouses= inexist.getWarehouses();
		      boolean exists= ewarehouses.stream().anyMatch((p) ->p.getWarehouseid().equals(first.getWarehouseid()));
			if (exists)
				   throw new UserAlreadyExistsException("User is  already there");
			   else
			   {
				   ewarehouses.addAll(userProfile.getWarehouses());
				   inexist.setWarehouses(ewarehouses);
				  result=UserServiceRepo.save(inexist);
			   }
		
		
			}
	           else
	         	result= UserServiceRepo.save(userProfile);
	
	           return result;
	}
	@Override
	public userProfile getUserByNameAndWarehouse(String userName, String warehouseid) throws UserProfileNotFoundException{
		// TODO Auto-generated method stub
		Optional<userProfile>userProfile = UserServiceRepo.findById(userName);
		
		if(userProfile.isPresent()) {
			List<warehouse>warehouses = userProfile.get().getWarehouses();
			while(warehouses.iterator().hasNext()) {
				warehouse warehouse = warehouses.iterator().next();
				if(warehouse.getWarehouseid().equals(warehouseid)){
					return userProfile.get();
				}
			}
			throw new UserProfileNotFoundException("User not found");
		}else {
			throw new UserProfileNotFoundException("User not found");
		}

	}

	@Override
	public userProfile addWarehouseToUser(String userName, warehouse warehouse) throws UserProfileNotFoundException, WarehouseAlreadyExistsException {

		Optional<userProfile> optionalUserProfile = UserServiceRepo.findById(userName);

		if(optionalUserProfile.isPresent()){
			userProfile userProfile = optionalUserProfile.get();

			Optional<warehouse> warehouse1 = userProfile.getWarehouses().stream().filter( w -> w.getWarehouseid().equals(warehouse.getWarehouseid())).findFirst();
			if(warehouse1.isEmpty()){
				userProfile.getWarehouses().add(warehouse);
				return UserServiceRepo.save(userProfile);
			}else{
//				throw new Exception("User is already associated with this warehouse");
				throw new WarehouseAlreadyExistsException("User is already associated with this warehouse");
			}


		}else{
			throw new UserProfileNotFoundException("User not found");
		}
	}

	@Override
	public List<userProfile> getByUserName(String userName) throws UserProfileNotFoundException {
		// TODO Auto-generated method stub
        try {
		Optional<userProfile>userProfile = UserServiceRepo.findById(userName);
		if(userProfile.isPresent()) {
			return UserServiceRepo.findByUserName(userName);
		}
			
//		} throw new UserProfileNotFoundException("User not found");
		else {
			 throw new UserProfileNotFoundException("User not found");
		}
	} catch(Exception e) {
		 throw new UserProfileNotFoundException("User not found");

	}

	
	

}
}