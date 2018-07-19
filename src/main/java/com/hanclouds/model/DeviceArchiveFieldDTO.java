package com.hanclouds.model;



/**
 * @author lih
 * @version 1.0
 * @date 2018/5/22 9:50
 */
public class DeviceArchiveFieldDTO {

    private String name;

    private String title;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "DeviceArchiveFieldDTO{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
