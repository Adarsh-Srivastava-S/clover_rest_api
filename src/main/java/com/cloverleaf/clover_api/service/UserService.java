package com.cloverleaf.clover_api.service;

import com.cloverleaf.clover_api.model.User;
import com.cloverleaf.clover_api.payloads.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User createUser(User user);
    public List<User> getAllUsers();
    public User getUser(Integer userId);
}
