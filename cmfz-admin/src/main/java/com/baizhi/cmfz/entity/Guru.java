package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.Pattern;

public class Guru{
    @Excel(name = "id")
    private String guruId;

    @Excel(name = "姓名")
    @Pattern(regexp =  "[\\u4E00-\\u9FA5]{2,5}", message = "姓名中文2-5位")
    private String guruName;

    private String guruPhoto;

    @Excel(name = "描述")
    private String guruSummary;

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId == null ? null : guruId.trim();
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName == null ? null : guruName.trim();
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto == null ? null : guruPhoto.trim();
    }

    public String getGuruSummary() {
        return guruSummary;
    }

    public void setGuruSummary(String guruSummary) {
        this.guruSummary = guruSummary == null ? null : guruSummary.trim();
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruSummary='" + guruSummary + '\'' +
                '}';
    }
}