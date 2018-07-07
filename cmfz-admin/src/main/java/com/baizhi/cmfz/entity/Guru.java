package com.baizhi.cmfz.entity;

public class Guru {
    private String guruId;

    private String guruName;

    private String guruPhoto;

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