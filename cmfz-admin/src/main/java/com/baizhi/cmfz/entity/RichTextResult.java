package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @program: cmfz
 * @description: 富文本图片返回处理
 * @author: zs
 * @create: 2018-07-08 19:34
 **/

public class RichTextResult {

    private Integer errno;
    private List<String> data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public static class Picture {
        private String pictureId;

        private String picturePath;

        @DateTimeFormat(pattern="yyyy-MM-dd")
        @JSONField(format="yyyy-MM-dd")
        private Date pictureDate;

        private String pictureDescription;

        private String pictureStatus;

        public String getPictureId() {
            return pictureId;
        }

        public void setPictureId(String pictureId) {
            this.pictureId = pictureId == null ? null : pictureId.trim();
        }

        public String getPicturePath() {
            return picturePath;
        }

        public void setPicturePath(String picturePath) {
            this.picturePath = picturePath == null ? null : picturePath.trim();
        }

        public Date getPictureDate() {
            return pictureDate;
        }

        public void setPictureDate(Date pictureDate) {
            this.pictureDate = pictureDate;
        }

        public String getPictureDescription() {
            return pictureDescription;
        }

        public void setPictureDescription(String pictureDescription) {
            this.pictureDescription = pictureDescription == null ? null : pictureDescription.trim();
        }

        public String getPictureStatus() {
            return pictureStatus;
        }

        public void setPictureStatus(String pictureStatus) {
            this.pictureStatus = pictureStatus == null ? null : pictureStatus.trim();
        }

        @Override
        public String toString() {
            return "Picture{" +
                    "pictureId='" + pictureId + '\'' +
                    ", picturePath='" + picturePath + '\'' +
                    ", pictureDate=" + pictureDate +
                    ", pictureDescription='" + pictureDescription + '\'' +
                    ", pictureStatus='" + pictureStatus + '\'' +
                    '}';
        }
    }
}
