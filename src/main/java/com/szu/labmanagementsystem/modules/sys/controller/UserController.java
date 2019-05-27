package com.szu.labmanagementsystem.modules.sys.controller;

import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.modules.sys.service.UserService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(path = "/usermanage")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/list")
    public PageUtils list(@RequestParam Map<String,Object> params){

        PageUtils pageUtils = userService.selectAllUser(params);

        return pageUtils;
    }

    @RequestMapping(path = "/update")
    public R update(@RequestBody UserEntity userEntity){

        userService.updateById(userEntity);

        return R.ok();
    }

    @RequestMapping(path = "/insert")
    public R insert(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
        return R.ok();
    }

    @RequestMapping(path = "/delete/{userId}")
    public R update(@PathVariable Long userId){
        userService.removeById(userId);
        return R.ok();
    }
}
