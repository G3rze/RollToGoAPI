package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.User;
import com.terraplanistas.api.notation.OwnerCheck.OwnerCheck;
import com.terraplanistas.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User createUser(@RequestBody User User) {
        return userService.save(User);
    }

    @PutMapping
    public User updateUser(@RequestBody User User) {
        return userService.update(User);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }


    @OwnerCheck(idParam = "id")
    public User getUserById(@PathVariable String id) {
        return userService.findById(id);
    }

}
