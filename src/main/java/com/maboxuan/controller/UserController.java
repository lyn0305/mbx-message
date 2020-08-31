package com.maboxuan.controller;


import com.maboxuan.entities.CommonResult;
import com.maboxuan.entities.MbxUser;
import com.maboxuan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestBody MbxUser mbxUser){
        CommonResult commonResult = userService.login(mbxUser);
        return commonResult;
    }

    @RequestMapping("/register")
    public CommonResult register(@RequestBody MbxUser mbxUser){
        CommonResult commonResult = userService.register(mbxUser);
        return commonResult;
    }

    @RequestMapping("/getAllMessage")
    @ResponseBody
    public CommonResult getAllMessage(){
        CommonResult allMessage = userService.getAllMessage();
        return allMessage;

    }
}
