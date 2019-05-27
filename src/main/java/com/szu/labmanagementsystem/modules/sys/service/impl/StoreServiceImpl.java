package com.szu.labmanagementsystem.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szu.labmanagementsystem.modules.sys.dao.StoreDAO;
import com.szu.labmanagementsystem.modules.sys.entity.StoreEntity;
import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.modules.sys.service.StoreService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("storeServiceImpl")
public class StoreServiceImpl extends ServiceImpl<StoreDAO,StoreEntity> implements StoreService {
    @Override
    public PageUtils selectAllGoods(Map<String, Object> params) {
        IPage<StoreEntity> page = this.page(
                new Query<StoreEntity>().getPage(params),
                new QueryWrapper<StoreEntity>()
        );
        return new PageUtils(page);
    }
}
