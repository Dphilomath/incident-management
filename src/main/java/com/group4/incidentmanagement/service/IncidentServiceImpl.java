package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.IncidentRepository;
import com.group4.incidentmanagement.dao.UpdateRepo;
import com.group4.incidentmanagement.dao.UserRepository;
import com.group4.incidentmanagement.entities.Incident;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.group4.incidentmanagement.service.util.IterableToList.makeCollection;

@Service
@Transactional
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepo;

    private final UserRepository userRepo;

    @Autowired
    private UpdateRepo updateRepo;

    //constructor injection
    public IncidentServiceImpl(@Autowired UserRepository userRepo, @Autowired IncidentRepository incidentRepo) {
        this.userRepo = userRepo;
        this.incidentRepo = incidentRepo;
    }

    @Override
    public Incident saveIncident(@NotNull Incident incident) {
        return incidentRepo.save(incident);
    }

    @Override
    public Incident getIncidentDetailsByUserId(Integer userId) {
        return null;
    }


    @Override
    public void deleteIncidentById(Integer incidentId) {
        incidentRepo.deleteById(incidentId);
    }

    @Override
    public Optional<Incident> getIncidentById(Integer incidentId) {
        return incidentRepo.findById(incidentId);
    }

    @Override
    public List<Incident> getAllIncidents() {
        Iterable<Incident> incidents = incidentRepo.findAll();
        return new ArrayList<>(makeCollection(incidents));
    }

    @Override
    public Incident updateIncident(Integer incidentId, Incident incident) {
        Optional<Incident> incidentOptional = incidentRepo.findById(incidentId);
        if (incidentOptional.isPresent()) {
            Incident updatedIncident = incidentOptional.get();
            updatedIncident.setName(incident.getName());
            updatedIncident.setPriority(incident.getPriority());
            updatedIncident.setStatus(incident.getStatus());
            updatedIncident.setCategory(incident.getCategory());
            return incidentRepo.save(incident);
        } else {
            throw new NoSuchElementException("Incident not found");
        }
    }

}
