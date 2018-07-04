package com.baizhi.cmfz.entity;

import java.util.Date;

public class Album {
    private String albumId;

    private String albumName;

    private String albumAuthor;

    private String albumSinger;

    private Integer albumCount;

    private Integer albumScore;

    private String albumPicture;

    private Date publishDate;

    private String albumContent;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId == null ? null : albumId.trim();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumAuthor() {
        return albumAuthor;
    }

    public void setAlbumAuthor(String albumAuthor) {
        this.albumAuthor = albumAuthor == null ? null : albumAuthor.trim();
    }

    public String getAlbumSinger() {
        return albumSinger;
    }

    public void setAlbumSinger(String albumSinger) {
        this.albumSinger = albumSinger == null ? null : albumSinger.trim();
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public Integer getAlbumScore() {
        return albumScore;
    }

    public void setAlbumScore(Integer albumScore) {
        this.albumScore = albumScore;
    }

    public String getAlbumPicture() {
        return albumPicture;
    }

    public void setAlbumPicture(String albumPicture) {
        this.albumPicture = albumPicture == null ? null : albumPicture.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAlbumContent() {
        return albumContent;
    }

    public void setAlbumContent(String albumContent) {
        this.albumContent = albumContent == null ? null : albumContent.trim();
    }
}