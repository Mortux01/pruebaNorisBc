package com.noris.prueba.bci.service.impl;

import com.noris.prueba.bci.components.UserParser;
import com.noris.prueba.bci.entities.User;
import com.noris.prueba.bci.model.UserModel;

import com.noris.prueba.bci.model.UserUpdateModel;
import com.noris.prueba.bci.repository.UserRepository;
import com.noris.prueba.bci.service.UserService;
import com.noris.prueba.bci.util.UserRegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.noris.prueba.bci.util.ConstantUtil.*;

//Esta clase realiza las validaciones correspondientes a el correo y contraseña antes de ser creado o actualizado el usuario.


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserParser userParser;

    @Value("${user.password.pattern.regexp}")
    private String PASSWORD_REGEX;

    @Value("${user.email.pattern.regexp}")
    private String EMAIL_REGEX;

    public User registerUser(UserModel userModel) {

        validateUserRequest(userModel);

        User newUser = userParser.createUserFromRequest(userModel);

        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(UserUpdateModel user) {

        validateUserUpdate(user);

        User newUser = userRepository.findByEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setIsactive(user.getIsactive());
        newUser.setModified(LocalDateTime.now());

        return userRepository.save(newUser);
    }

    private void validateUserRequest(UserModel userModel) {

        Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = patternEmail.matcher(userModel.getEmail());

        Pattern patternPass = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Matcher passMatcher = patternPass.matcher(userModel.getPassword());

        if (!emailMatcher.matches()) {
            throw new UserRegistrationException(FORMAT_MAIL_INVALID);
        }
        if (!passMatcher.matches()) {
            throw new UserRegistrationException(FORMAT_PASS_INVALID);
        }
        User existingUser = userRepository.findByEmail(userModel.getEmail());
        if (existingUser != null) {
            throw new UserRegistrationException(REGISTERED_MAIL);
        }
    }

    private void validateUserUpdate(UserUpdateModel userModel) {

        Pattern patternEmail = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = patternEmail.matcher(userModel.getEmail());

        Pattern patternPass = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Matcher passMatcher = patternPass.matcher(userModel.getPassword());

        if (!emailMatcher.matches()) {
            throw new UserRegistrationException(FORMAT_MAIL_INVALID);
        }
        if (!passMatcher.matches()) {
            throw new UserRegistrationException(FORMAT_PASS_INVALID);
        }
        User existingUser = userRepository.findByEmail(userModel.getEmail());
        if (existingUser == null) {
            throw new UserRegistrationException(ERROR_REGISTERED_MAIL);
        }
    }

}

