package com.szu.labmanagementsystem.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;


public interface UserService extends IService<UserEntity> {

    UserEntity getUserByUserName(String userName);
}
