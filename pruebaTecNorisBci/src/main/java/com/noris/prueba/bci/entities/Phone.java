package com.noris.prueba.bci.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TELEFONOS")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "citycode")
    private String citycode;

    @Column(name = "countrycode")
    private String countrycode;
}
