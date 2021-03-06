package com.szu.labmanagementsystem.modules.sys.controller;

import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import com.szu.labmanagementsystem.modules.sys.entity.StoreEntity;
import com.szu.labmanagementsystem.modules.sys.service.StoreService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/storemanage")
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping(path = "/list")
    public PageUtils list(@RequestParam Map<String,Object> params){
        PageUtils pageUtils = storeService.selectAllGoods(params);
        return pageUtils;
    }

    @RequestMapping(path = "/update")
    public R update(@RequestBody StoreEntity userEntity){

        storeService.updateById(userEntity);

        return R.ok();
    }

    @RequestMapping(path = "/insert")
    public R insert(@RequestBody StoreEntity userEntity){
        storeService.save(userEntity);
        return R.ok();
    }

    @RequestMapping(path = "/delete/{userId}")
    public R update(@PathVariable Long userId){
        storeService.removeById(userId);
        return R.ok();
    }

}
