package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.UserEntity;
import com.aspectworks.active24.api.rest.vo.UserVO;

import java.util.List;

public interface UserService {
    void createUser(UserEntity user);


    void deleteUser(String username);

    List<UserEntity> getAllUsers();

    }
