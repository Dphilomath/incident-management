package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //Create or save or add
    public User createUser(User user);

    //Retrieve or get student on the basis of Primary Key
    public Optional<User> getUserById(Integer userId);

    //Update
    public User updateUser(Integer userId, User user);

    //Delete
    public void deleteUser(Integer userId);

    public List<User> getAllUsers();

    Optional<List<Incident>> getAllIncidents(Integer userId);
}
