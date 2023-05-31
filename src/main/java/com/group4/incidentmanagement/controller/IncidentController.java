package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.dao.UpdateRepo;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "*")
public class IncidentController {
    private IncidentService incidentService;

    @Autowired
    private UpdateRepo updateRepo;

    //setter dependency injection
    @Autowired
    private void setIncidentService(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/incidents")
    ResponseEntity<List<Incident>> getAllIncidents() {
        List<Incident> incidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

    //Create or save or add
    //http://localhost:8080/addincident
    @PostMapping("/incident/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.saveIncident(incident);
    }

    //Retrieve or get student on the basis of Primary Key
    //http://localhost:8080/getincidentbyid/1
    @GetMapping("/incident/{incidentId}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable("incidentId") Integer incidentId) {
        return incidentService.getIncidentById(incidentId)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/incident/update/{incidentId}")
    public ResponseEntity<Incident> updateIncident(@PathVariable("incidentId") Integer incidentId, Incident incident) {
        Incident updatedIncident = incidentService.updateIncident(incidentId, incident);
        return ResponseEntity.ok(updatedIncident);
    }

    @DeleteMapping("/incident/delete/{incidentId}")
    public ResponseEntity<String> deleteIncident(@PathVariable("incidentId") Integer incidentId) {
        incidentService.deleteIncidentById(incidentId);
        return new ResponseEntity<String>("Incident deleted successfully!.", HttpStatus.OK);
    }

}
