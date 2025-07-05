package com.terraplanistas.api.controller;

import com.terraplanistas.api.controller.requestDTO.UserCreateDTO;
import com.terraplanistas.api.model.User;
import com.terraplanistas.api.notation.OwnerCheck.OwnerCheck;
import com.terraplanistas.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        if (userService.findByUsername(userCreateDTO.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario '" + userCreateDTO.getUsername() + "' ya está en uso.");
        }
        if (userService.findByEmail(userCreateDTO.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo electrónico '" + userCreateDTO.getEmail() + "' ya está registrado.");
        }
        User user = new User();
        user.setId(userCreateDTO.getUid());
        user.setUserImageUrl(userCreateDTO.getUserImageUrl());
        user.setUsername(userCreateDTO.getUsername());
        user.setEmail(userCreateDTO.getEmail());
        user.setCreatedAt(OffsetDateTime.now());

        try {
            User savedUser = userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el usuario: " + e.getMessage());
        }
    }
    @PutMapping
    public User updateUser(@RequestBody User User) {
        return userService.update(User);
    }

    @OwnerCheck
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.findById(id);
    }

}
