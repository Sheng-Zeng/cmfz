package com.baizhi.cmfz.entity;

import java.util.Date;

public class Article {
    private String articleId;

    private String articleName;

    private String guruId;

    private String articleIntroduction;

    private Date articleDate;

    private String articlePicturePic;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId == null ? null : guruId.trim();
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction == null ? null : articleIntroduction.trim();
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticlePicturePic() {
        return articlePicturePic;
    }

    public void setArticlePicturePic(String articlePicturePic) {
        this.articlePicturePic = articlePicturePic == null ? null : articlePicturePic.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", guruId='" + guruId + '\'' +
                ", articleIntroduction='" + articleIntroduction + '\'' +
                ", articleDate=" + articleDate +
                ", articlePicturePic='" + articlePicturePic + '\'' +
                '}';
    }
}