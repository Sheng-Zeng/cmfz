package com.baizhi.cmfz.entity;

public class Admin {
    private String adminId;

    private String adminName;

    private String adminPwd;

    private String adminSolt;

    private String adminStatus;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    public String getAdminSolt() {
        return adminSolt;
    }

    public void setAdminSolt(String adminSolt) {
        this.adminSolt = adminSolt == null ? null : adminSolt.trim();
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus == null ? null : adminStatus.trim();
    }
}