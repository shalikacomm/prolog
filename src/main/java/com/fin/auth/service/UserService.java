package com.fin.auth.service;

import com.fin.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
