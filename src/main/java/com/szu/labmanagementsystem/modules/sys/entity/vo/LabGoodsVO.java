package com.szu.labmanagementsystem.modules.sys.entity.vo;

import java.util.Date;

public class LabGoodsVO {

    private Long id;
    private Long goodsId;
    private Long labId;
    private String goodsName;
    private String labName;
    private Long goodsAmount;
    private Date gmtCreate;

    public LabGoodsVO() {
    }

    public LabGoodsVO(Long id, Long goodsId, Long labId, String goodsName, String labName, Long goodsAmount, Date gmtCreate) {
        this.id = id;
        this.goodsId = goodsId;
        this.labId = labId;
        this.goodsName = goodsName;
        this.labName = labName;
        this.goodsAmount = goodsAmount;
        this.gmtCreate = gmtCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public Long getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Long goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
