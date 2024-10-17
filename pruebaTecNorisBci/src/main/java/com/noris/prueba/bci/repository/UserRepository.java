package com.noris.prueba.bci.repository;


import com.noris.prueba.bci.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Este es el repositorio para implementar los llamos a Base de datos Mediante JPA.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}