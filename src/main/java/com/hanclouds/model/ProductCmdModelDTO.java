package com.hanclouds.model;




/**
 * @Description
 * @Author huyunsen
 * @Date 2022/6/16 10:47
 * @Version 1.0
 */
public class ProductCmdModelDTO {
    private String productKey;
    private String title;
    private String identifier;
    private Integer modelType;
    private String model;

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
