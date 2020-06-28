package com.example.vhr.service;

import com.example.vhr.mapper.EmployeeMapper;
import com.example.vhr.model.Employee;
import com.example.vhr.model.RespPageBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    EmployeeMapper employeeMapper;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page, Integer size,Employee employee,Date[] beginDataScope) {
        if(page!=null&&size!=null){
            page = (page-1)*size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page,size,employee,beginDataScope);
        System.out.println(employee);
        Long total = employeeMapper.getTotal(employee,beginDataScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Date begincontract = employee.getBegincontract();
        Date endcontract = employee.getEndcontract();
        double month =(Double.parseDouble(yearFormat.format(endcontract))-
                Double.parseDouble(yearFormat.format(begincontract)))*12+
                (Double.parseDouble(monthFormat.format(endcontract))-
                        Double.parseDouble(monthFormat.format(begincontract)));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(month/12)));
        int result = employeeMapper.insertSelective(employee);
        if(result ==1){
            Employee emp= employeeMapper.getEmployeeById(employee.getId());
            rabbitTemplate.convertAndSend("mail.welcome",emp);

        }
        return result;
    }

    public Integer maxWorkId() {
        return employeeMapper.maxWorkId();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        Date begincontract = employee.getBegincontract();
        Date endcontract = employee.getEndcontract();
        double month =(Double.parseDouble(yearFormat.format(endcontract))-
                Double.parseDouble(yearFormat.format(begincontract)))*12+
                (Double.parseDouble(monthFormat.format(endcontract))-
                        Double.parseDouble(monthFormat.format(begincontract)));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(month/12)));
        return employeeMapper.updateByPrimaryKey(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }
}
