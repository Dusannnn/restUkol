package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.UserEntity;
import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserVO user){
        UserEntity userEntity = new UserEntity(user);
        userService.createUser(userEntity);
        System.out.println("Creating new user: " + user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{username}")
    public void deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        System.out.println("Deleting user with username: " + username);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
}
