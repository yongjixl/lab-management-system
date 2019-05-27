package com.szu.labmanagementsystem.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szu.labmanagementsystem.modules.sys.dao.LabGoodsDAO;
import com.szu.labmanagementsystem.modules.sys.entity.LabGoodsEntity;
import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import com.szu.labmanagementsystem.modules.sys.entity.vo.LabGoodsVO;
import com.szu.labmanagementsystem.modules.sys.service.LabGoodsService;
import com.szu.labmanagementsystem.utils.PageUtils;
import com.szu.labmanagementsystem.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("labGoodsServiceImpl")
public class LabGoodsServiceImpl extends ServiceImpl<LabGoodsDAO,LabGoodsEntity> implements LabGoodsService {


    @Override
    public PageUtils selectAllLabGoods(Map<String, Object> params) {
        IPage<LabGoodsVO> page = new Query<LabGoodsVO>().getPage(params);
        List<LabGoodsVO> labGoodsEntityList =  baseMapper.selectAllLabGoods(page,params);
        page.setRecords(labGoodsEntityList);
        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertOrUpdate(LabGoodsEntity insertOrUpdateEntity) {
        this.saveOrUpdate(insertOrUpdateEntity);
    }
}
