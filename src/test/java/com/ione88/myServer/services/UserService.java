package com.ione88.myServer.services;

import com.ione88.myServer.services.entity.User;

public interface UserService {

    void addUser(User user);

    Iterable<User> getAll();
}
