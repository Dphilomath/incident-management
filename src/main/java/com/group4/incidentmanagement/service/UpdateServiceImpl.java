package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.UpdateRepo;
import com.group4.incidentmanagement.entities.Update;
import com.group4.incidentmanagement.service.util.IterableToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateServiceImpl implements UpdateService{

    @Autowired
    private UpdateRepo updateRepo;

    @Override
    public List<Update> saveUpdate(String incidentName, Update update) {
return null;
    }

    @Override
    public List<Update> getAllUpdates(String incidentName) {
        return new ArrayList<>(IterableToList.makeCollection(updateRepo.findByIncident_Name(incidentName)));
    }
}
