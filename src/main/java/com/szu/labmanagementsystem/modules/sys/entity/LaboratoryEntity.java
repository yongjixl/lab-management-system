package com.szu.labmanagementsystem.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("tb_lab")
public class LaboratoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @TableField("lab_id")
    private Long labId;

    @TableField("lab_name")
    private String labName;

    public LaboratoryEntity() {

    }

    public LaboratoryEntity(Long labId, String labName) {
        this.labId = labId;
        this.labName = labName;
    }

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }
}
