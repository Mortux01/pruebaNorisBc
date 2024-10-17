package com.noris.prueba.bci.service;

import com.noris.prueba.bci.entities.User;
import com.noris.prueba.bci.model.UserModel;
import com.noris.prueba.bci.model.UserUpdateModel;


public interface UserService {
    User registerUser(UserModel UserModel);

    User updateUser(UserUpdateModel user);
}
