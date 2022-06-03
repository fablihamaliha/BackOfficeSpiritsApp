package com.cgi.AuthService.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cgi.AuthService.model.User;

import org.mockito.MockitoAnnotations;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    
    @Autowired
    private UserRepository userAuthRepository;
    
    private User user;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();

        user.setPassword("123456");
        user.setUsername("John");
    }

    @AfterEach
    public void tearDown() throws Exception {
    	userAuthRepository.deleteAll();
    }


    @Test
    public void testRegisterUserSuccess() {
    	userAuthRepository.save(user);
        User fetchUser = userAuthRepository.findById(user.getUsername()).get();
        assertThat(user.getUsername(), is(fetchUser.getUsername()));
    }

    @Test
    public void testLoginUserSuccess() {
    	userAuthRepository.save(user);
        User fetchUser = userAuthRepository.findById(user.getUsername()).get();
        assertThat(user.getUsername(), is(fetchUser.getUsername()));
    }

}

