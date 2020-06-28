package com.example.vhr.controller.system.basic;

import com.example.vhr.mapper.JObLevelMapper;
import com.example.vhr.model.JObLevel;
import com.example.vhr.model.RespBean;
import com.example.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<JObLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JObLevel jObLevel){
        if(jobLevelService.addJobLevel(jObLevel)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JObLevel jObLevel){
        if(jobLevelService.updateJobLevel(jObLevel)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable int id){
        if(jobLevelService.deleteJobLevel(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids){
        if(jobLevelService.deleteJobLevelsByIds(ids)==ids.length){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
