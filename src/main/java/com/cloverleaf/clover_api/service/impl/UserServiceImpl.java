package com.cloverleaf.clover_api.service.impl;

import com.cloverleaf.clover_api.exceptions.ResourceNotFoundException;
import com.cloverleaf.clover_api.model.User;
import com.cloverleaf.clover_api.payloads.UserDto;
import com.cloverleaf.clover_api.repo.UserRepository;
import com.cloverleaf.clover_api.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
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
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        User user1=this.userRepository.save(user);
        return user1;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=this.userRepository.findAll();
        return users;
    }
    @Override
    public User getUser(Integer userId) {

//        User user = this.userRepository(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User","id",userId));

        return   null;
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
