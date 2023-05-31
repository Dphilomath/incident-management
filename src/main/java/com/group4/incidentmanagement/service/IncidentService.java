package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.entities.Incident;

import java.util.List;
import java.util.Optional;

public interface IncidentService {
    //C - Create or Insert
    public Incident saveIncident(Incident incident);

    //R - Retrieve or find
    public Incident getIncidentDetailsByUserId(Integer userId);

    public Optional<Incident> getIncidentById(Integer incidentId);

    //D - Delete a record
    public void deleteIncidentById(Integer incidentId);

    public List<Incident> getAllIncidents();

    Incident updateIncident(Integer incidentId, com.group4.incidentmanagement.entities.Incident incident);
}
