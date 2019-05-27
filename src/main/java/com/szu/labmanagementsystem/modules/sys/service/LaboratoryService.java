package com.szu.labmanagementsystem.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import com.szu.labmanagementsystem.utils.PageUtils;

import java.util.Map;

public interface LaboratoryService extends IService<LaboratoryEntity> {
    PageUtils selectAllLab(Map<String, Object> params);
}
