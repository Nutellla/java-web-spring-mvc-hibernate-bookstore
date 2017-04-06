package com.nickstell.services;

import com.nickstell.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
    List<User> listUsers();
}
