package com.zln.cmfz.entity;

/**
 * Created by zhanglijiao on 2018/7/9.
 */
public class Echarts {

    private String name;
    private String value;

    public Echarts() {
        super();
    }

    public Echarts(String name, String value) {
        this.name = name;
        this.value = value;
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
        return "Echarts{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
