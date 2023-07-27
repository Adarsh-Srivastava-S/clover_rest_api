package com.cloverleaf.clover_api.repo;

import com.cloverleaf.clover_api.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {
public User findByUserName(String username);
public User findByEmail(String email);
}

