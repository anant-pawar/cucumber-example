package com.bosch.repository;

import com.bosch.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Anant on 04-07-2017.
 */
public interface UserRepository extends MongoRepository<User, String>{

    @Query("{'name' : ?0}")
    public User getUserByName(String name);
}
