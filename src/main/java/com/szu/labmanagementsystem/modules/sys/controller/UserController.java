package com.szu.labmanagementsystem.modules.sys.controller;

import com.szu.labmanagementsystem.modules.sys.service.UserService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping(path = "/usermanage")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/list")
    public R list(@RequestParam Map<String,Object> params){

        PageUtils pageUtils = userService.selectAllUser(params);

        return R.ok().put("data",pageUtils);
    }
}
