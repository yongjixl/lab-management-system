package com.szu.labmanagementsystem.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LaboratoryDAO extends BaseMapper<LaboratoryEntity> {
}
