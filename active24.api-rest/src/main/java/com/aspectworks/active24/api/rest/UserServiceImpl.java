package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.UserEntity;
import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<UserEntity> users = new ArrayList<>();

    @Autowired
    UserRepository userRepository;


    public void createUser(UserEntity user){
        userRepository.save(user);
    }

    public void deleteUser(String username){
//        for (UserVO user : users){
//            if (user.getUsername().equals(username)){
//                users.remove(user);
//            }
//        }
        userRepository.deleteByUsername(username);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
