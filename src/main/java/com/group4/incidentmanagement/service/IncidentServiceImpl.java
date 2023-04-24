package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.IncidentRepository;
import com.group4.incidentmanagement.dao.UpdateRepo;
import com.group4.incidentmanagement.dao.UserRepository;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.Update;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IncidentServiceImpl implements IncidentService {

    private IncidentRepository incidentRepo;

    private UserRepository userRepo;

    @Autowired
    private UpdateRepo updateRepo;
    //constructor injection
    public IncidentServiceImpl(@Autowired UserRepository userRepo, @Autowired IncidentRepository incidentRepo) {
        this.userRepo = userRepo;
        this.incidentRepo = incidentRepo;
    }

    @Override
    public Incident saveIncident(@NotNull Incident incident) {

//        User foundUser = userRepo.findUserByUserNameAndDepartment(incident.getUser().getUserName(), incident.getUser().getDepartment());
//
//        if (foundUser != null) {
//            incident.setUser(foundUser);
//        }
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
    public Incident getIncidentById(Integer incidentId){
        Optional<Incident> incident = incidentRepo.findById(incidentId);
        return incident.orElse(null);
    }

    @Override
    public List<Incident> getAllIncidents() {
        Iterable<Incident> incidents = incidentRepo.findAll();
        return new ArrayList<>(makeCollection(incidents));
    }

    @Override
    public Incident updateIncident(String incidentName, Update update){
        Incident toUpdate = incidentRepo.findIncidentByName(incidentName);
        update.setIncident(toUpdate);
        List<Update>  updates = toUpdate.getUpdates();
        updates.add(update);
        Update curUpdate = updateRepo.save(update);
        Incident updated = incidentRepo.findIncidentByName(incidentName);
        return updated;

    }
    public static <E> Collection<E> makeCollection(Iterable<E> iter) {
        Collection<E> list = new ArrayList<>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }
}
