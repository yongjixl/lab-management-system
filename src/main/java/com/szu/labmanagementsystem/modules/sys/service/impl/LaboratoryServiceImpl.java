package com.szu.labmanagementsystem.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szu.labmanagementsystem.modules.sys.dao.LaboratoryDAO;
import com.szu.labmanagementsystem.modules.sys.entity.LaboratoryEntity;
import com.szu.labmanagementsystem.modules.sys.service.LaboratoryService;
import org.springframework.stereotype.Service;

@Service("laboratoryServiceImpl")
public class LaboratoryServiceImpl extends ServiceImpl<LaboratoryDAO,LaboratoryEntity> implements LaboratoryService {

}
