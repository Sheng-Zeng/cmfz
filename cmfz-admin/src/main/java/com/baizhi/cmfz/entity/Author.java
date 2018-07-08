package com.baizhi.cmfz.entity;

/**
 * @program: cmfz
 * @description: 作者选择
 * @author: zs
 * @create: 2018-07-08 19:02
 **/

public class Author {

    private String id;
    private String text;

    public Author() {
    }

    public Author(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
