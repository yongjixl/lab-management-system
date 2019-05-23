package com.szu.labmanagementsystem.modules.sys.controller;

import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam String userName,@RequestParam String passWord){

        UserEntity userByUserName = userService.getUserByUserName(userName);
        if(userByUserName != null && userByUserName.getPassWord().equals(passWord)){
            return "labmanage";
        }else{
            return "error";
        }
    }
}
