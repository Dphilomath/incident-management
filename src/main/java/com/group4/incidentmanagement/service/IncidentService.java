package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.entities.Incident;

import java.util.List;

public interface IncidentService {
    //C - Create or Insert
    public Incident saveIncident(Incident incident);
    //R - Retrieve or find
    public Incident getIncidentDetailsByUserId(Integer userId);
    public Incident getIncidentById(Integer incidentId);

    //D - Delete a record
    public void deleteIncidentById(Integer incidentId);
    public List<Incident> getAllIncidents();

}
