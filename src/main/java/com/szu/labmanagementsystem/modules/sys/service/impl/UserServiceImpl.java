package com.szu.labmanagementsystem.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szu.labmanagementsystem.modules.sys.dao.UserDAO;
import com.szu.labmanagementsystem.modules.sys.entity.UserEntity;
import com.szu.labmanagementsystem.modules.sys.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDAO,UserEntity>  implements UserService {


    @Override
    public UserEntity getUserByUserName(String userName) {
        return baseMapper.getUserByUserName(userName);
    }
}
