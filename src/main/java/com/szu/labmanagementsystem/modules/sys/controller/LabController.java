package com.szu.labmanagementsystem.modules.sys.controller;

import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.modules.sys.service.LaboratoryService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/labmanage")
public class LabController {

    @Autowired
    LaboratoryService laboratoryService;

    @RequestMapping(path = "/list")
    public PageUtils list(@RequestParam Map<String,Object> params){
        PageUtils pageUtils = laboratoryService.selectAllLab(params);
        return pageUtils;
    }

    @RequestMapping(path = "/update")
    public R update(@RequestBody LaboratoryEntity userEntity){

        laboratoryService.updateById(userEntity);

        return R.ok();
    }

    @RequestMapping(path = "/insert")
    public R insert(@RequestBody LaboratoryEntity userEntity){
        laboratoryService.save(userEntity);
        return R.ok();
    }

    @RequestMapping(path = "/delete/{userId}")
    public R update(@PathVariable Long userId){
        laboratoryService.removeById(userId);
        return R.ok();
    }

}
