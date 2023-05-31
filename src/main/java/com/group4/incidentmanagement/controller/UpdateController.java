package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.entities.Update;
import com.group4.incidentmanagement.service.UpdateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/update/add/{incidentId}")
    @Transactional
    public List<Update> addUpdate(@PathVariable("incidentId") Integer incidentId, @RequestBody Update update) {
        System.out.println("IncidentID: " + incidentId);
        return updateService.saveUpdate(incidentId, update);
    }

    @GetMapping("/updates/{incidentId}")
    public List<Update> getUpdates(@PathVariable("incidentId") Integer incidentId) throws NoSuchFieldException {
        System.out.println("incidentId: " + incidentId);
        return updateService.getAllUpdates(incidentId);
    }
}
