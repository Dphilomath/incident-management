package com.group4.incidentmanagement.controller;

import com.group4.incidentmanagement.dao.DepartmentRepository;
import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.entities.User;
import com.group4.incidentmanagement.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class DepartmentController {
    @Autowired
    private DepartmentService deptService;

    @Autowired
    private DepartmentRepository deptRepo;

    @GetMapping("/depts")
    List<Department> getAllDepartments() {
        return deptService.getAllDepts();
    }

    //Create or save or add
    @PostMapping("/dept/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Department createDepartment(@Valid @RequestBody Department dept, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "Validation failed";
            throw new ValidationException(errorMessage);
        }
        return deptService.createDept(dept);

    }

    //Retrieve or get student on the basis of Primary Key
    @GetMapping("/dept/{id}")
    public ResponseEntity<Department> retrieveDept(@PathVariable("id") Integer deptId) {
        Department dept = deptService.getDeptById(deptId);
        if (dept != null) return ResponseEntity.ok(dept);
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/dept/update/{id}")
    public ResponseEntity<Department> updateDept(@PathVariable("id") Integer deptId, @RequestBody Department dept) {
        try {
            Department savedDept = deptService.getDeptById(deptId);
            savedDept.setDeptName(dept.getDeptName());

            Department updatedDept = deptService.updateDept(savedDept);
            return new ResponseEntity<>(updatedDept, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/dept/delete/{deptId}")
    public ResponseEntity<String> deleteDept(@PathVariable("deptId") Integer deptId) {
        deptService.deleteDeptById(deptId);
        return new ResponseEntity<String>("Department deleted successfully!.", HttpStatus.OK);

    }

    @GetMapping("/dept/users/{deptId}")
    public ResponseEntity<List<User>> getUsersByDeptId(@PathVariable("deptId") Integer deptId) {
        List<User> users = deptService.getUsersByDepartmentId(deptId);
        return ResponseEntity.ok(users);
    }
}