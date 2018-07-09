package com.baizhi.cmfz.entity;

/**
 * @program: cmfz
 * @description: 成员分布
 * @author: zs
 * @create: 2018-07-09 15:00
 **/

public class Agreement {

    // 城市名称
    private String name;
    // 人数
    private String value;

    public Agreement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Agreement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
