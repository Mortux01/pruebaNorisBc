package com.noris.prueba.bci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {

    private String name;
    private String email;
    private String password;
    private List<PhoneModel> phones;
}
