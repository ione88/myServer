package com.ione88.myServer.service.impl;

import com.ione88.myServer.service.entity.User;
import com.ione88.myServer.service.UserService;
import com.ione88.myServer.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(User user) {
        User userPersist = userRepository.findByEmail(user.getEmail());
        if (userPersist == null) {
            userRepository.save(user);
            return;
        }
        userPersist.setName(user.getName());
        userRepository.save(userPersist);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

}