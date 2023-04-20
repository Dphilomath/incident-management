package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.User;
import com.group4.incidentmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getallusers")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    //Create or save or add
    //http://localhost:8080/addstudent
    @PostMapping("/adduser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);

    }

    //Retrieve or get student on the basis of Primary Key
    //http://localhost:8080/getstudentbyid/1
    @GetMapping("/getuserbyid/{id}")
    public User retrieveUser(@PathVariable("id") Integer userId) {
        return userService.retrieveUser(userId);
    }


}
