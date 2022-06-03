package com.cgi.UserService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgi.UserService.model.userProfile;

@Repository
public interface UserServiceRepo extends MongoRepository<userProfile, String>{

	 List<userProfile> findByUserName(String userName) ;

}