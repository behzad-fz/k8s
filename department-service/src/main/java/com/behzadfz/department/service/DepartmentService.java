package com.behzadfz.department.service;

import com.behzadfz.department.entity.Department;
import com.behzadfz.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside Service@save");
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) {
        log.info("Inside Service@getDepartmentById");
        return departmentRepository.findDepartmentById(departmentId);
    }
}
