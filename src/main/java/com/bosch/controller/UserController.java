package com.bosch.controller;

import com.bosch.model.User;
import com.bosch.repository.UserRepository;
import com.bosch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Anant on 04-07-2017.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userRepository.save(user);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId){
        return userRepository.findOne(userId);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable("name") String name){
        return userRepository.getUserByName(name);
    }
}
