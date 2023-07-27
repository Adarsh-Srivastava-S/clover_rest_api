package com.cloverleaf.clover_api.security;

import com.cloverleaf.clover_api.exceptions.UsernameAlreadyExistsException;
import com.cloverleaf.clover_api.exceptions.UsernameNotExistsException;
import com.cloverleaf.clover_api.model.User;
import com.cloverleaf.clover_api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email)  {

        User user=null;
        try {
            user = this.userRepository.findByEmail(email);
        }catch (Exception e)
        {
            user=null;
        }
        if(user==null)
        {
            user=this.userRepository.findByUserName(email);
        }



        if(user==null) {
            System.out.println("User not found");
            throw new UsernameNotExistsException("No user found in database !!"+email);
//            throw new UsernameAlreadyExistsException("Username already exists: "+user.getUsername());

        }
        return user;
    }
}
