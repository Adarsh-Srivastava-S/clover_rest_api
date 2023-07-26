package com.cloverleaf.clover_api.repo;

import com.cloverleaf.clover_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
public User findByUserName(String username);
}

