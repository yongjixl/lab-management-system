package com.szu.labmanagementsystem.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szu.labmanagementsystem.modules.sys.entity.LabGoodsEntity;
import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import com.szu.labmanagementsystem.modules.sys.entity.StoreEntity;
import com.szu.labmanagementsystem.modules.sys.service.LabGoodsService;
import com.szu.labmanagementsystem.modules.sys.service.StoreService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/labstoremanage")
public class LabStoreController {

    @Autowired
    LabGoodsService labGoodsService;

    @Autowired
    StoreService storeService;

    @RequestMapping(path = "/list")
    public PageUtils list(@RequestParam Map<String,Object> params){
        PageUtils pageUtils = labGoodsService.selectAllLabGoods(params);
        return pageUtils;
    }

    @RequestMapping(path = "/update")
    public R update(@RequestBody LabGoodsEntity labGoodsEntity){

        StoreEntity storeEntity = storeService.getById(labGoodsEntity.getGoodsId());
        Long goodsStock = storeEntity.getGoodsStock();

        Long needAmount = labGoodsEntity.getGoodsAmount();
        LabGoodsEntity oldEntity = labGoodsService.getById(labGoodsEntity.getId());
        Long oldAmount = oldEntity.getGoodsAmount();

        if(needAmount > oldAmount){
            if(needAmount > goodsStock){
                return R.error("需要的数量超过库存");
            }else{
                labGoodsService.updateById(labGoodsEntity);
                storeEntity.setGoodsStock(storeEntity.getGoodsStock() - (needAmount - oldAmount));
                storeService.updateById(storeEntity);
            }
        }else{
            labGoodsService.updateById(labGoodsEntity);
            storeEntity.setGoodsStock(storeEntity.getGoodsStock() + (oldAmount - needAmount));
            storeService.updateById(storeEntity);
        }

        return R.ok();
    }

    @RequestMapping(path = "/insert")
    public R insert(@RequestBody LabGoodsEntity labGoodsEntity){

        LabGoodsEntity entity =labGoodsService.getOne(
                new QueryWrapper<LabGoodsEntity>()
                        .eq("goods_id",labGoodsEntity.getGoodsId())
                        .eq("lab_id",labGoodsEntity.getLabId()));

        StoreEntity storeEntity = storeService.getById(labGoodsEntity.getGoodsId());

        Long goodsStock = storeEntity.getGoodsStock();

        LabGoodsEntity insertOrUpdateEntity = null;
        if(entity != null){
            entity.setGoodsAmount(entity.getGoodsAmount()+labGoodsEntity.getGoodsAmount());
            if(labGoodsEntity.getGoodsAmount() > goodsStock){
                return R.error("需要的数量超过库存");
            }
            insertOrUpdateEntity = entity;
            storeEntity.setGoodsStock(goodsStock - labGoodsEntity.getGoodsAmount());
        }else{
            if(labGoodsEntity.getGoodsAmount() > goodsStock){
                return R.error("需要的数量超过库存");
            }
            insertOrUpdateEntity = labGoodsEntity;
            storeEntity.setGoodsStock(storeEntity.getGoodsStock() - insertOrUpdateEntity.getGoodsAmount());
        }

        labGoodsService.insertOrUpdate(insertOrUpdateEntity);
        storeService.updateById(storeEntity);

        return R.ok();
    }

    @RequestMapping(path = "/delete/{userId}")
    public R update(@PathVariable Long userId){

        LabGoodsEntity labGoodsEntity = labGoodsService.getById(userId);
        Long goodsAmount = labGoodsEntity.getGoodsAmount();
        labGoodsService.removeById(userId);

        StoreEntity storeEntity = storeService.getById(labGoodsEntity.getGoodsId());
        storeEntity.setGoodsStock(storeEntity.getGoodsStock() + goodsAmount);
        storeService.updateById(storeEntity);

        return R.ok();
    }
}
