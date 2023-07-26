package com.cloverleaf.clover_api.controllers;

import com.cloverleaf.clover_api.model.User;
import com.cloverleaf.clover_api.model.auth.JwtRequest;
import com.cloverleaf.clover_api.model.auth.JwtResponse;
import com.cloverleaf.clover_api.security.CustomUserDetailService;
import com.cloverleaf.clover_api.security.JwtTokenHelper;
//import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @PostMapping("/generate-token")
    public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }
        catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }
        UserDetails userDetails=this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtTokenHelper.generateToken(userDetails);

        System.out.println(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (DisabledException e)
        {
            throw new Exception("USER DISABLE"+e.getMessage());
        }
        catch(BadCredentialsException e)
        {
            throw new Exception("Invalid Credentials "+e.getMessage());
        }

    }
    // Get Current User After Getting token
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
        User user=(User) this.customUserDetailService.loadUserByUsername(principal.getName());
        return user;
    }

}