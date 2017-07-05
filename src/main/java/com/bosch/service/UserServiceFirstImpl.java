package com.bosch.service;

import com.bosch.model.User;
import com.bosch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Anant on 04-07-2017.
 */
public class UserServiceFirstImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(String id) {
        System.out.println("\n\n\n\n\nfirst\n\n\n\n\n");
        return userRepository.findOne(id);
    }
}
