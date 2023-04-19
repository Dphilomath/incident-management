package com.group4.incidentmanagement;

import com.group4.incidentmanagement.entities.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public User getUser(){
        return new User();
    }
}

