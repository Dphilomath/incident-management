package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.DepartmentRepository;
import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.service.util.IterableToList;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository deptRepo;

    @Override
    public Department createDepartment(Department dept) {
        return deptRepo.save(dept);
    }

    @Override
    public Department retrieveDepartment(Integer deptId) {
        Optional<Department> dept = deptRepo.findById(deptId);
        if (dept.isPresent()) return dept.get();
        else return null;
    }

    @Override
    public Department updateDepartment(Department department) {
        Optional<Department> dept = deptRepo.findById(department.getDeptId());
        if (dept.isPresent()) return deptRepo.save(department);
        else return null;
    }

    @Override
    public void deleteDepartment(Integer deptId) {
        deptRepo.deleteById(deptId);

    }

    @Override
    public List<Department> getAllDepartments() {
        Iterable<Department> depts = deptRepo.findAll();
        return new ArrayList<>(IterableToList.makeCollection(depts));
    }
}
