package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.service.DepartmentService;
import com.group4.incidentmanagement.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService deptService;

    @GetMapping("/getalldepts")
    List<Department> getAllDepts() {
        return deptService.getAllDepartments();
    }


    //Create or save or add
    //http://localhost:8080/adddept
    @PostMapping("/adddept")
    public Department createIncident(@RequestBody Department dept) {
        return deptService.createDepartment(dept);
    }

    //Retrieve or get student on the basis of Primary Key
    //http://localhost:8080/getdeptbyid/1
    @GetMapping("/getdeptbyid/{id}")
    public Department retrieveDept(@PathVariable("id") Integer deptId) {
        return deptService.retrieveDepartment(deptId);
    }
}
