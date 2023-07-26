package com.cloverleaf.clover_api.service.impl;

import com.cloverleaf.clover_api.exceptions.GlobalExceptionHandler;
import com.cloverleaf.clover_api.exceptions.ResourceNotFoundException;
import com.cloverleaf.clover_api.exceptions.UsernameAlreadyExistsException;
import com.cloverleaf.clover_api.model.User;
import com.cloverleaf.clover_api.payloads.UserDto;
import com.cloverleaf.clover_api.repo.UserRepository;
import com.cloverleaf.clover_api.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(User user) {
        User user_=null;


        user_=this.userRepository.findByUserName(user.getUsername());

        if(user_!=null) {
            System.out.println("User is already there !!.");
            throw new UsernameAlreadyExistsException("Username already exists: "+user.getUsername());
        }
        else
        {
            user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
            user_ = this.userRepository.save(user);
            return user_;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=this.userRepository.findAll();
        return users;
    }
    @Override
    public User getUser(Integer userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
        return   user;
    }
    @Override
    public User getUserByUsername(String username)
    {
        User user=this.userRepository.findByUserName(username);
        return user;
    }
//    public UserDto userToDto(User user)
//    {
//        //Error
//        UserDto userDto=  this.modelMapper.map(user,UserDto.class);
//
//
//        return userDto;
//    }

}
