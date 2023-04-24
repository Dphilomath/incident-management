package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.entities.Update;
import com.group4.incidentmanagement.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/addanupdate/{incidentName}")
    public List<Update> addUpdate(@PathVariable("incidentName") String incidentName, @RequestBody Update update){
        System.out.println(incidentName);
        return updateService.saveUpdate(incidentName, update);
    }
    @GetMapping("/getupdates/{incidentName}")
    public List<Update> getUpdates(@PathVariable("incidentName") String incidentName){
        return updateService.getAllUpdates(incidentName);
    }
}
