package com.szu.labmanagementsystem.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("tb_lab_store")
public class LabGoodsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Long id;

    @TableField("lab_id")
    private Long labId;

    @TableField("goods_id")
    private Long goodsId;

    @TableField("goods_amount")
    private Long goodsAmount;

}
