package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.dao.UpdateRepo;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class IncidentController {
    private IncidentService incidentService;

    @Autowired
    private UpdateRepo updateRepo;

    //setter dependency injection
    @Autowired
    private void setIncidentService(  IncidentService incidentService){
        this.incidentService = incidentService;
    }

    @GetMapping("/getallincidents")
    List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }


    //Create or save or add
    //http://localhost:8080/addincident
    @PostMapping("/add/incident")
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.saveIncident(incident);
    }

    //Retrieve or get student on the basis of Primary Key
    //http://localhost:8080/getincidentbyid/1
    @GetMapping("/incident/{incidentId}")
    public Incident retrieveIncident(@PathVariable("incidentId") Integer incidentId) {
        return incidentService.getIncidentById(incidentId);
    }

    @DeleteMapping("/incident/delete/{incidentId}")
    public void deleteIncident(@PathVariable("incidentId") Integer incidentId) {
        incidentService.deleteIncidentById(incidentId);
    }

}
