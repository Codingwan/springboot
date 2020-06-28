package com.example.vhr.controller.system.basic;

import com.example.vhr.model.Position;
import com.example.vhr.model.RespBean;
import com.example.vhr.service.PositionService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;
    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }
    @PostMapping("/add")
    public RespBean addPosition(@RequestBody Position position){
        if(positionService.addPosition(position) == 1){
            return RespBean.ok("添加成功！！");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/delete")
    public RespBean deletePosition(@RequestBody Position position){
        if(positionService.deletePosition(position)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/deleteBatch")
    public RespBean deleteBatchPosition(@RequestBody int[] ids){
        System.out.println(ids);
        if(positionService.deleteBatchPosition(ids)==ids.length){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @RequestMapping("/update")
    public RespBean updatePosition(@RequestBody Position position){
        if(positionService.updatePosition(position) == 1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
