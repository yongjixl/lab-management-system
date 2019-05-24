package com.szu.labmanagementsystem.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.utils.PageUtils;

import java.util.Map;


public interface UserService extends IService<UserEntity> {

    UserEntity getUserByUserName(String userName);

    PageUtils selectAllUser(Map<String, Object> param);
}
