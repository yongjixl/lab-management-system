package com.szu.labmanagementsystem.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("tb_store")
public class StoreEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @TableField("goods_id")
    private Long goodsId;

    @TableField("goods_name")
    private String goodsName;

    @TableField("goods_stock")
    private Long goodsStock;

    public StoreEntity() {
    }

    public StoreEntity(Long goodsId, String goodsName, Long goodsStock) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsStock = goodsStock;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Long goodsStock) {
        this.goodsStock = goodsStock;
    }
}
