package com.szu.labmanagementsystem.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szu.labmanagementsystem.modules.sys.entity.LabGoodsEntity;
import com.szu.labmanagementsystem.utils.PageUtils;

import java.util.Map;

public interface LabGoodsService extends IService<LabGoodsEntity> {
    PageUtils selectAllLabGoods(Map<String, Object> params);

    void insertOrUpdate(LabGoodsEntity insertOrUpdateEntity);
}
