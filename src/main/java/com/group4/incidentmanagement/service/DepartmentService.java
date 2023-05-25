package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public Department createDept(Department department);

    public Department updateDeptById(Integer deptId, Department dept);

    public void deleteDeptById(Integer deptId);

    public Department getDeptById(Integer deptId);

    public List<Department> getAllDepts();

    Department updateDept(String deptName, Update update);
}
