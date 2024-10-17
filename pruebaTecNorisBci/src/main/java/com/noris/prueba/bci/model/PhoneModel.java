package com.noris.prueba.bci.model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneModel {

    private String number;
    private String citycode;
    private String countrycode;
}
