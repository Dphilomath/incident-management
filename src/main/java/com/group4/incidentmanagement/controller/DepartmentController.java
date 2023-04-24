package com.group4.incidentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	 @PostMapping("/adddepartment")
	    public Department createIncident(@RequestBody Department department) {
	        return departmentService.createDepartment(department);
	    }
}
