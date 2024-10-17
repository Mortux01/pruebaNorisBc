package com.noris.prueba.bci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateModel {

    private String name;
    private String email;
    private String password;
    private Boolean isactive;
}
