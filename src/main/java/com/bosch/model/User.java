package com.bosch.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Anant on 04-07-2017.
 */
public class User {
    private String id;
    private String name;
    private Integer age;
    private String mobile;

    @JsonCreator
    public User(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("age") Integer age,
            @JsonProperty("mobile") String mobile) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }
}
