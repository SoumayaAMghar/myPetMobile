package com.example.api.services;

import com.example.api.model.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findByEmail(String email);

}
