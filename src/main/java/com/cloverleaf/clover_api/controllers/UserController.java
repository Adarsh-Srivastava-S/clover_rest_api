package com.cloverleaf.clover_api.controllers;

import com.cloverleaf.clover_api.model.User;
import com.cloverleaf.clover_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/test")
    public String testBackEnd()
    {
        return "Backend Working.....";
    }
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1=this.userService.createUser(user);
        return ResponseEntity.ok(user1);
    }
    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> users=this.userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable("username") String username)
    {
        User user=this.userService.getUserByUsername(username);
        return ResponseEntity.ok(user);

    }
}

