package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.UserRepository;
import com.group4.incidentmanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User retrieveUser(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) return user.get();
        else return null;
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }
}
