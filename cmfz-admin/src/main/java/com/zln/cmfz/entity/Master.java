package com.zln.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Created by zhanglijiao on 2018/7/6.
 * 上师实体类
 */
public class Master {

    // easypoi  @Excel 指定excel表格中列和属性的映射关系

    private Integer masterId;

    @Excel(name = "上师法名")
    private String masterName;

    @Excel(name = "上师图片")
    private String masterPhoto;

    @Excel(name = "上师简介")
    private String masterSummary;

    public Master() {
        super();
    }

    public Master(Integer masterId, String masterName, String masterPhoto, String masterSummary) {
        this.masterId = masterId;
        this.masterName = masterName;
        this.masterPhoto = masterPhoto;
        this.masterSummary = masterSummary;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummary() {
        return masterSummary;
    }

    public void setMasterSummary(String masterSummary) {
        this.masterSummary = masterSummary;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummary='" + masterSummary + '\'' +
                '}';
    }
}
