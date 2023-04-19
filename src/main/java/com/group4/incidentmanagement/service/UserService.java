package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.entities.User;

public interface UserService {
    //Create or save or add
    public User createUser(User user);

    //Retrieve or get student on the basis of Primary Key
    public User retrieveUser(Integer userId);

    //Update
    public User updateUser(User user);

    //Delete
    public void deleteUser(Integer userId);
}
