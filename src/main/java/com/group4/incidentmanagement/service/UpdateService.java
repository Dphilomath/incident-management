package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.entities.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UpdateService {
    List<Update> saveUpdate(Integer incidentId, Update update);

    List<Update> getAllUpdates(Integer incidentId) throws NoSuchFieldException;
}
