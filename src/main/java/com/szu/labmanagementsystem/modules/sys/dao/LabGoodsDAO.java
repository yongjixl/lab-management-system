package com.szu.labmanagementsystem.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.szu.labmanagementsystem.modules.sys.entity.LabGoodsEntity;
import com.szu.labmanagementsystem.modules.sys.entity.vo.LabGoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LabGoodsDAO extends BaseMapper<LabGoodsEntity>{
    List<LabGoodsVO> selectAllLabGoods(IPage<LabGoodsVO> page, Map<String, Object> params);

}
