package com.cgi.UserService.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class userProfile {
	

	@Id
	String userName;

//	LocalDateTime createdAt;
	List<warehouse>warehouses;
	



	public userProfile(String userName, List<warehouse> warehouses) {
		super();
		this.userName = userName;
//		this.createdAt = createdAt;
		this.warehouses = warehouses;
	}
	public userProfile() {
	super();
}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<warehouse> getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(List<warehouse> warehouses) {
		this.warehouses = warehouses;
	}
	@Override
	public String toString() {
		return "userProfile [userName=" + userName + ", warehouses=" + warehouses + "]";
	}

	
	
   
  

}