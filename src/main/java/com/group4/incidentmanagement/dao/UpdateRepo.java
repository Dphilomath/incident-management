package com.group4.incidentmanagement.dao;

import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.Update;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateRepo extends CrudRepository<Update, Integer> {
    public List<Update> findByIncident_Name(String incidentName);
}
