package com.example.vhr.controller.emp;

import com.example.vhr.model.*;
import com.example.vhr.service.*;
import com.example.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emp/basic")
public class EmBasicController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NationService nationService;

    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PositionService positionService;
    @Autowired
    PoliticsstatusService politicsstatusService;

    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(name="page",defaultValue = "1") Integer page ,
                                          @RequestParam(name="size",defaultValue = "10") Integer size,
                                          Employee employee,Date[] beginDataScope){
        System.out.println(employee.toString());
        System.out.println(Arrays.toString(beginDataScope));
        return employeeService.getEmployeeByPage(page,size,employee,beginDataScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if(employeeService.addEmp(employee)==1){
            return RespBean.ok("添加员工成功");
        }
        return RespBean.error("添加员工失败");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")
    public List<JObLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }


    @GetMapping("/maxWorkId")
    public RespBean maxWorkId(){
        return RespBean.build().setStatus(200)
                .setObj(Integer.parseInt(String.format("%08d",employeeService.maxWorkId())) +1);
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepertment();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id){
        if(employeeService.deleteEmpByEid(id) == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        if(employeeService.updateEmp(employee)==1){
            return  RespBean.ok("更新成功");
        }
        return  RespBean.error("更新失败");
    }

    /*文件down*/
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list = (List<Employee>) employeeService.getEmployeeByPage(null,null,new Employee(),null).getData();

        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list =POIUtils.excel2Employee(file,nationService.getAllNations(),politicsstatusService.getAllPoliticsstatus()
        ,departmentService.getAllDepertmentwithOutChildren(),positionService.getAllPositions(),jobLevelService.getAllJobLevels());
        //插入数据
        System.out.println(list.size());
        if(employeeService.addEmps(list)==list.size()){
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }

}
