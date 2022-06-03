package com.cgi.UserService.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cgi.UserService.model.userProfile;
import com.cgi.UserService.model.warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class UserRepositoryTest {
	@Autowired 
	private UserServiceRepo UserServiceRepo;
	
	private  userProfile userProfile;
	 private List<userProfile>userList;
	 
	    @BeforeEach
	    public void setUp(){

	        userList=new ArrayList<userProfile>();

	        List<warehouse> warehouseList1 = new ArrayList<warehouse>();
	        warehouse warehouse1 = new warehouse("213","Montreal");

	        warehouseList1.add(warehouse1);

	        userProfile = new userProfile("TEST_2019",warehouseList1);
	        userProfile userProfile2 = new userProfile("TEST2_123",warehouseList1);

	        userList.add(userProfile);
	        userList.add(userProfile2);
	    }
	    @AfterEach
	    public void tearDown() throws Exception{
	        UserServiceRepo.deleteById("TEST_2019");
	    }
	 @Test 
		 public void testsaveUserName() {
		
			 UserServiceRepo.save(userProfile);
			 assertThat(userProfile.getUserName()).isEqualTo("TEST_2019");
		 }
	 
//	 @Test
//	 public void testFindAll() {
//		 UserServiceRepo.save(userProfile);
//		 List<userProfile> userList = UserServiceRepo.findAll();
//		 assertThat(userList.size()).isEqualTo(10);
//
//
//
//
//	 }
}
