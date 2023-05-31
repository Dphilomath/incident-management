package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.DepartmentRepository;
import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.group4.incidentmanagement.service.util.IterableToList.makeCollection;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository deptRepo;
    /**
     * @param department
     * @return
     */
    @Override
    public Department createDept(Department department) throws IllegalArgumentException {
        return deptRepo.save(department);
    }

    /**
     * @param deptId
     * @return
     */
    @Override
    public Department updateDeptById(Integer deptId, Department newDept) {
        newDept.setDeptId(deptId);
        return deptRepo.save(newDept);
    }

    /**
     * @param deptId
     */
    @Override
    public void deleteDeptById(Integer deptId) {
        deptRepo.deleteById(deptId);
    }

    /**
     * @param deptId
     * @return
     */
    @Override
    public Department getDeptById(Integer deptId) {
        Optional<Department> dept = deptRepo.findById(deptId);
        if (dept.isPresent()) return dept.get();

        throw new NoSuchElementException("No dept with deptId: " + deptId + " found");
    }

    @Override
    public List<Department> getAllDepts() {
        Iterable<Department> depts = deptRepo.findAll();
        return new ArrayList<>(makeCollection(depts));
    }

    @Override
    public Department updateDept(Department savedDept) {
        return deptRepo.save(savedDept);
    }

    /**
     * @param deptId
     * @return
     */
    @Override
    public List<User> getUsersByDepartmentId(Integer deptId) {
        Optional<Department> deptOptional = deptRepo.findById(deptId);
        if (deptOptional.isPresent()) {
            Department dept = deptOptional.get();
            List<User> users = dept.getUsers();
            return users;
        } else throw new NoSuchElementException();
    }
}
