package com.example.vhr.service;

import com.example.vhr.mapper.SalaryMapper;
import com.example.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;
    public List<Salary> getAllSalaries() {

        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreatedate(new Date());

        return  salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalaryById(Salary salary) {
        salary.setCreatedate(new Date());
        return  salaryMapper.updateByPrimaryKey(salary);
    }
}
