package com.ironhack.plantisserver.service.interfaces;

import com.ironhack.plantisserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();


}
