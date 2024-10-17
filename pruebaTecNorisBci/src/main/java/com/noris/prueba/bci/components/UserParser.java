package com.noris.prueba.bci.components;


import com.noris.prueba.bci.entities.Phone;
import com.noris.prueba.bci.entities.User;
import com.noris.prueba.bci.model.PhoneModel;
import com.noris.prueba.bci.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//En esta clase se realiza la logica para crear los objetos para crear y modificar.

@Component
public class UserParser {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public User createUserFromRequest(UserModel userModel) {

        User newUser = new User();
        newUser.setId(UUID.randomUUID());
        newUser.setName(userModel.getName());
        newUser.setEmail(userModel.getEmail());
        newUser.setPassword(userModel.getPassword());

        List<Phone> phones =  userModel.getPhones().stream()
                .map(this::createPhoneFromRequest)
                .collect(Collectors.toList());
        newUser.setPhones(phones);

        LocalDateTime currentDate = LocalDateTime.now();
        newUser.setCreated(currentDate);
        newUser.setModified(currentDate);
        newUser.setLast_login(currentDate);

        String accessToken = Jwts.builder()
                .setSubject(newUser.getEmail())
                .setIssuedAt(new Date())
                .signWith(SECRET_KEY)
                .compact();
        newUser.setToken(accessToken);
        newUser.setIsactive(true);

        return newUser;
    }

    public User updateUserFromRequest(UserModel userModel) {

        User newUser = new User();
        newUser.setId(UUID.randomUUID());
        newUser.setName(userModel.getName());
        newUser.setEmail(userModel.getEmail());
        newUser.setPassword(userModel.getPassword());

        List<Phone> phones =  userModel.getPhones().stream()
                .map(this::createPhoneFromRequest)
                .collect(Collectors.toList());
        newUser.setPhones(phones);

        LocalDateTime currentDate = LocalDateTime.now();
        newUser.setCreated(currentDate);
        newUser.setModified(currentDate);
        newUser.setLast_login(currentDate);

        String accessToken = Jwts.builder()
                .setSubject(newUser.getEmail())
                .setIssuedAt(new Date())
                .signWith(SECRET_KEY)
                .compact();
        newUser.setToken(accessToken);
        newUser.setIsactive(true);

        return newUser;
    }

    private Phone createPhoneFromRequest(PhoneModel phoneModel) {
        Phone phone = new Phone();

        phone.setNumber(phoneModel.getNumber());
        phone.setCitycode(phoneModel.getCitycode() != null ? phoneModel.getCitycode() : "");
        phone.setCountrycode(phoneModel.getCountrycode() != null ? phoneModel.getCountrycode() : "");
        return phone;
    }
}

