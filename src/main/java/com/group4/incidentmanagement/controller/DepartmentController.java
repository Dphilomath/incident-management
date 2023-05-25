package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.dao.DepartmentRepository;
import com.group4.incidentmanagement.dao.UpdateRepo;
import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.Update;
import com.group4.incidentmanagement.service.DepartmentService;
import com.group4.incidentmanagement.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class DepartmentController {
        @Autowired
        private DepartmentService deptService;

        @Autowired
        private DepartmentRepository deptRepo;

        @GetMapping("/getalldepts")
        List<Department> getAllDepts() {
            return deptService.getAllDepts();
        }


        //Create or save or add
        //http://localhost:8080/adddept
        @PostMapping("/adddept")
        public Department createDept(@RequestBody Department dept) {
            return deptService.createDept(dept);
        }

        //Retrieve or get student on the basis of Primary Key
        //http://localhost:8080/getdeptbyid/1
        @GetMapping("/getdeptbyid/{id}")
        public Department retrieveDept(@PathVariable("id") Integer deptId) {
            return deptService.getDeptById(deptId);
        }

        @PutMapping("/updatedept/{deptName}")
        public Department updateDept(@PathVariable("deptName") String deptName, @RequestBody Update update) {
            System.out.println(update.toString());
            return deptService.updateDept(deptName, update);
        }

}
