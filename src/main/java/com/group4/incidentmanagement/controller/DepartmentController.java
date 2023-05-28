package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.dao.DepartmentRepository;
import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.exception.NoSuchElementFoundException;
import com.group4.incidentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class DepartmentController {
    @Autowired
    private DepartmentService deptService;

    @Autowired
    private DepartmentRepository deptRepo;

    @GetMapping("/alldepts")
    List<Department> getAllDepts() {
        return deptService.getAllDepts();
    }


    //Create or save or add
    @PostMapping("/dept/add")
    public Department createDept(@RequestBody Department dept) {
        return deptService.createDept(dept);
    }

    //Retrieve or get student on the basis of Primary Key
    @GetMapping("/dept/{id}")
    public Department retrieveDept(@PathVariable("id") Integer deptId) {
        return deptService.getDeptById(deptId);
    }

    @PutMapping("/dept/update/{id}")
    public Department updateDept(@PathVariable("id") Integer deptId, @RequestBody Department dept) {
        return deptService.updateDeptById(deptId, dept);
    }

    @DeleteMapping("/dept/delete/{deptId}")
    public void deleteDept(@PathVariable("deptId") Integer deptId) {
        deptService.deleteDeptById(deptId);
    }

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            NoSuchElementFoundException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
