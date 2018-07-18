package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<UserVO> users = new ArrayList<>();


    public void createUser(UserVO user){
        users.add(user);
    }

    public void deleteUser(String username){
        for (UserVO user : users){
            if (user.getUsername().equals(username)){
                users.remove(user);
            }
        }
    }

    public List<UserVO> getAllUsers(){
        return users;
    }
}
