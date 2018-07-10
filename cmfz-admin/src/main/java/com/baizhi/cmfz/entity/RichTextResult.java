package com.baizhi.cmfz.entity;

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
}