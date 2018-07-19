package com.hanclouds.model;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 14:14
 */
public class DataStreamAddDTO {
    /**
     * 数据流标识，用于匹配
     */
    private String dataName;

    /**
     * 数据流名称，用于展示
     */
    private String title;

    /**
     * 单位名称
     */
    private String dataUnit;

    /**
     * 单位符号
     */
    private String unitSymbol;

    /**
     * 数据类型
     */
    private Integer dataType;

    /**
     * 数据流描述
     */
    private String desc;

    /**
     * 业务类型
     */
    private Integer bussinessType;

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(Integer bussinessType) {
        this.bussinessType = bussinessType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DataStreamAddDTO{" +
                "dataName='" + dataName + '\'' +
                ", title='" + title + '\'' +
                ", dataUnit='" + dataUnit + '\'' +
                ", unitSymbol='" + unitSymbol + '\'' +
                ", dataType=" + dataType +
                ", desc='" + desc + '\'' +
                ", bussinessType=" + bussinessType +
                '}';
    }
}
