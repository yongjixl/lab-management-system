package com.szu.labmanagementsystem.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO extends BaseMapper<UserEntity> {
    UserEntity getUserByUserName(@Param("userName") String userName);
}
