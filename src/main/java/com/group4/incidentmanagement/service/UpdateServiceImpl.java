package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.IncidentRepository;
import com.group4.incidentmanagement.dao.UpdateRepo;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.Update;
import com.group4.incidentmanagement.service.util.IterableToList;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateRepo updateRepo;

    @Autowired
    private IncidentRepository incidentRepo;

    //look here
    @Override
    public List<Update> saveUpdate(Integer incidentId, Update update) {

        Incident incident = incidentRepo.findById(incidentId).orElseThrow(() -> new EntityNotFoundException("Incident not found with ID: " + incidentId));

        System.out.println("incident before update addition" + incident);
        update.setIncident(incident);
        incident.getUpdates().add(update);
        incidentRepo.save(incident);
        System.out.println("incident after update addition" + incident);
        return incidentRepo.findById(incidentId).get().getUpdates();
    }

    @Override
    public List<Update> getAllUpdates(Integer incidentId) throws NoSuchFieldException {
        Optional<Incident> incident = incidentRepo.findById(incidentId);
        System.out.println(incident.get().getUpdates());
        if (incident.isPresent()) return new ArrayList<>(IterableToList.makeCollection(incident.get().getUpdates()));
        throw new NoSuchFieldException("No incident with incidentId: " + incidentId);
    }

}
