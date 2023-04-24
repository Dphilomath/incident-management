package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UpdateService {
    public List<Update> saveUpdate(String incidentName,Update update);
    public List<Update> getAllUpdates(String incidentName);
}
