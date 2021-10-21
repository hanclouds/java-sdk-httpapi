package com.hanclouds.model;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 14:49
 */
public class DataStreamDTO {
    /**
     * 数据流id
     */
    private Integer id;

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
     *数据流描述
     */
    private String desc;

    /**
     * 代码内容
     */
    private String jsonSchema;

    /**
     * 业务类型
     */
    private Integer bussinessType;

    /**
     * 流类型：1为设备数据流，2为流计算数据流
     */
    private Short streamType;

    /**
     * 0-自定义功能，1-标准功能
     */
    private Boolean standard;

    /**
     * 0-新数据流，1-老数据流
     */
    private Boolean oldTag;

    /**
     * 模型对象
     */
    private String model;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getJsonSchema() {
        return jsonSchema;
    }

    public void setJsonSchema(String jsonSchema) {
        this.jsonSchema = jsonSchema;
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

    public Short getStreamType() {
        return streamType;
    }

    public void setStreamType(Short streamType) {
        this.streamType = streamType;
    }

    public Boolean getStandard() {
        return standard;
    }

    public void setStandard(Boolean standard) {
        this.standard = standard;
    }

    public Boolean getOldTag() {
        return oldTag;
    }

    public void setOldTag(Boolean oldTag) {
        this.oldTag = oldTag;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "DataStreamDTO{" +
                "id=" + id +
                ", dataName='" + dataName + '\'' +
                ", title='" + title + '\'' +
                ", dataUnit='" + dataUnit + '\'' +
                ", unitSymbol='" + unitSymbol + '\'' +
                ", dataType=" + dataType +
                ", desc='" + desc + '\'' +
                ", jsonSchema='" + jsonSchema + '\'' +
                ", bussinessType=" + bussinessType +
                ", streamType=" + streamType +
                ", standard=" + standard +
                ", oldTag=" + oldTag +
                ", model='" + model + '\'' +
                '}';
    }
}
