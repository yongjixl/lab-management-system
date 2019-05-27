package com.szu.labmanagementsystem.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szu.labmanagementsystem.modules.sys.dao.LaboratoryDAO;
import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.modules.sys.service.LaboratoryService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("laboratoryServiceImpl")
public class LaboratoryServiceImpl extends ServiceImpl<LaboratoryDAO,LaboratoryEntity> implements LaboratoryService {

    @Override
    public PageUtils selectAllLab(Map<String, Object> params) {
        IPage<LaboratoryEntity> page = this.page(
                new Query<LaboratoryEntity>().getPage(params),
                new QueryWrapper<LaboratoryEntity>()
        );
        return new PageUtils(page);
    }
}
