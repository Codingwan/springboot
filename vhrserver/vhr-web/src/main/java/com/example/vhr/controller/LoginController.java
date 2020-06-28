package com.example.vhr.controller;

import com.example.vhr.model.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    //@CrossOrigin("*")
    public RespBean login(){
        return RespBean.error("尚未登录，请先登录");
    }
}
