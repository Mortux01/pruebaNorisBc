package com.noris.prueba.bci.controller;



import com.noris.prueba.bci.entities.User;
import com.noris.prueba.bci.model.UserModel;
import com.noris.prueba.bci.model.UserUpdateModel;
import com.noris.prueba.bci.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "companies resource")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "este metodo corresponde a una prueba que inserta valores de un usuario nuevo")
    @PostMapping("/insert")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user) {
        try {
            User createdUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"mensaje\": \"" + e.getMessage() + "\"}");
        }
    }

    @Operation(summary = "este metodo corresponde a una prueba que actualiza valores de un usuario ya creado")
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateModel user) {
        try {
            User updateUser = userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"mensaje\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("El controlador está funcionando");
    }
}
