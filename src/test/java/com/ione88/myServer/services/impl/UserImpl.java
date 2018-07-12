package com.ione88.myServer.services.impl;

import com.ione88.myServer.services.entity.User;
import com.ione88.myServer.services.UserService;
import com.ione88.myServer.services.repository.UserRepository;
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