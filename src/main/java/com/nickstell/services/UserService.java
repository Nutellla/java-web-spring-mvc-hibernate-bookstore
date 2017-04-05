package com.nickstell.services;

import com.nickstell.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
