package com.cgi.AuthService.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cgi.AuthService.exceptions.UserAlreadyExistsException;
import com.cgi.AuthService.exceptions.UserNotFoundException;
import com.cgi.AuthService.model.User;
import com.cgi.AuthService.repository.UserRepository;

import java.util.Optional;

public class ServiceTest {

    @Mock
    private UserRepository userAuthRepository;

    private User user;
    @InjectMocks
    private UserAuthServiceImpl userAuthServiceImpl;

    Optional<User> optional;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new User();

        user.setPassword("123456");
        user.setUsername("John123");
        optional = Optional.of(user);
    }

    @Test
    public void testSaveUserSuccess() throws UserAlreadyExistsException {

        Mockito.when(userAuthRepository.save(user)).thenReturn(user);
        boolean flag = userAuthServiceImpl.saveUser(user);
        assertEquals(true, flag);

    }


    @Test
    public void testSaveUserFailure() {

        Mockito.when(userAuthRepository.findById("John123")).thenReturn(optional);
        Mockito.when(userAuthRepository.save(user)).thenReturn(user);
        assertThrows(
        		UserAlreadyExistsException.class,
                    () -> { userAuthServiceImpl.saveUser(user); });

    }

    @Test
    public void testFindByUserIdAndPassword() throws UserNotFoundException {
        Mockito.when(userAuthRepository.findByUsernameAndPassword("John123", "123456")).thenReturn(user);
        User fetchedUser = userAuthServiceImpl.findByUsernameAndPassword("John123", "123456");
        assertEquals("John123", fetchedUser.getUsername());
    }
}

