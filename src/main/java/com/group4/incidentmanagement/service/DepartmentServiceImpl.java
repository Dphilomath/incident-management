package com.group4.incidentmanagement.service;

import com.group4.incidentmanagement.dao.DepartmentRepository;
import com.group4.incidentmanagement.entities.Department;
import com.group4.incidentmanagement.entities.Incident;
import com.group4.incidentmanagement.entities.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        if(dept.isPresent()) return dept.get();
        else return null;
    }

    @Override
    public List<Department> getAllDepts() {
        Iterable<Department> depts = deptRepo.findAll();
        return new ArrayList<>(makeCollection(depts));
    }

    /**
     * @param deptName
     * @param update
     * @return
     */
    @Override
    public Department updateDept(String deptName, Update update) {
        return null;
    }
}
