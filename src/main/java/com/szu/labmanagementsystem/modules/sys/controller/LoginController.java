package com.szu.labmanagementsystem.modules.sys.controller;

import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.modules.sys.service.UserService;
import com.szu.labmanagementsystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord,HttpServletRequest request){
        UserEntity userByUserName = userService.getUserByUserName(userName);
        if(userByUserName != null && userByUserName.getPassWord().equals(passWord)){
            HttpSession session=request.getSession();//获取session并将userName存入session对象
            session.setAttribute("userName", userName);
            return "usermanage";
        }else{
            return "error";
        }
    }

    @RequestMapping(path = "/user/logout",method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
}
