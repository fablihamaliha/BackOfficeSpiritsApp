package com.cgi.AuthService.controller;


import com.cgi.AuthService.model.User;
import com.cgi.AuthService.service.UserAuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
@WebMvcTest

public class controllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAuthService userAuthService;

    
    private User user;

    @InjectMocks
    private UserController userAuthController;


    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userAuthController).build();

        user = new User();
        user.setPassword("123456");
        user.setUsername("John123");
        
    }

    @Test
    public void testRegisterUser() throws Exception {

        Mockito.when(userAuthService.saveUser(user)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/api/register").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
                .andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void testLoginUser() throws Exception {


        String userId = "John123";
        String password = "123456";


        Mockito.when(userAuthService.saveUser(user)).thenReturn(true);
        Mockito.when(userAuthService.findByUsernameAndPassword(userId, password)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/api/login").contentType(MediaType.APPLICATION_JSON).content(jsonToString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    // Parsing String format data into JSON format
    private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try {
        	
        	ObjectMapper objmapper = new ObjectMapper();
        	objmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        	objmapper.registerModule(new JavaTimeModule());
            result = objmapper.writeValueAsString(obj);
            
        } catch (JsonProcessingException e) {
            result = "Json processing error";
        }
        return result;
    }
}