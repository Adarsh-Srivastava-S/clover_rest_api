package com.cloverleaf.clover_api.controllers;

import com.cloverleaf.clover_api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @GetMapping("/test")
    public String testBackEnd()
    {
        return "Backend Working.....";
    }
//    @PostMapping("/")
//    public ResponseEntity<User> createUser(@RequestBody)
//    {
//return 0;
//    }

}

