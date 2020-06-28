package com.example.vhr.service;

import com.example.vhr.mapper.DepartmentMapper;
import com.example.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getAllDepertment() {
        return departmentMapper.getAllDepertmentByParentId(-1);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }

    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }

    public List<Department> getAllDepertmentwithOutChildren() {
        return departmentMapper.getAllDepertmentwithOutChildren();
    }
}
