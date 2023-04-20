package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.DepartmentRepository;
import com.group4.incidentmanagement.entities.Department;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
