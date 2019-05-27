package com.szu.labmanagementsystem.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szu.labmanagementsystem.modules.sys.entity.StoreEntity;
import com.szu.labmanagementsystem.utils.PageUtils;

import java.util.Map;

public interface StoreService extends IService<StoreEntity> {
    PageUtils selectAllGoods(Map<String, Object> params);
}
