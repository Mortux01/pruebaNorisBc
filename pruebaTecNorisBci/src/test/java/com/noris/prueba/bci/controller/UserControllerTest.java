package com.noris.prueba.bci.controller;


import com.noris.prueba.bci.entities.User;
import com.noris.prueba.bci.model.UserModel;
import com.noris.prueba.bci.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUserSuccess() {
        UserModel userModel = new UserModel();
        userModel.setName("Eduardo Nunez");
        userModel.setEmail("edNunez@gmail.com");
        userModel.setPassword("norisprueba5");

        User savedUser = new User();
        savedUser.setId(UUID.randomUUID());
        savedUser.setName(userModel.getName());
        savedUser.setEmail(userModel.getEmail());
        savedUser.setPassword(userModel.getPassword());
        LocalDateTime currentDate = LocalDateTime.now();
        savedUser.setCreated(currentDate);
        savedUser.setModified(currentDate);
        savedUser.setLast_login(currentDate);
        savedUser.setToken(UUID.randomUUID().toString());
        savedUser.setIsactive(true);

        Mockito.when(userService.registerUser(userModel)).thenReturn(savedUser);

        ResponseEntity<?> responseEntity = userController.registerUser(userModel);
        assertEquals(savedUser, responseEntity.getBody());
    }


}
