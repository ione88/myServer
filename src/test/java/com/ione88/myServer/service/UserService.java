package com.ione88.myServer.service;

import com.ione88.myServer.service.entity.User;

public interface UserService {

    void addUser(User user);

    Iterable<User> getAll();
}
