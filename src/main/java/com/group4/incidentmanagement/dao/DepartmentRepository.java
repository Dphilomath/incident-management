package com.group4.incidentmanagement.dao;

import com.group4.incidentmanagement.entities.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
