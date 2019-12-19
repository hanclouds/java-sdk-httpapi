package com.hanclouds.model;

import java.util.Date;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class ProductDTO {
    private Date createAt;
    private Date updateAt;
    private String projectKey;
    private String productKey;
    private String userKey;
    private String productName;
    private String descr;
    private Integer productStatus;
    private String productIndustry;
    private String productCategory;
    private String disableReason;
    private Object extendData;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductIndustry() {
        return productIndustry;
    }

    public void setProductIndustry(String productIndustry) {
        this.productIndustry = productIndustry;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Object getExtendData() {
        return extendData;
    }

    public void setExtendData(Object extendData) {
        this.extendData = extendData;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    @Override
    public String toString() {
        return "ProductDTO{"
                + "createAt="
                + createAt
                + ", updateAt="
                + updateAt
                + ", projectKey='"
                + projectKey
                + '\''
                + ", productKey='"
                + productKey
                + '\''
                + ", userKey='"
                + userKey
                + '\''
                + ", productName='"
                + productName
                + '\''
                + ", descr='"
                + descr
                + '\''
                + ", productStatus="
                + productStatus
                + ", productIndustry='"
                + productIndustry
                + '\''
                + ", productCategory='"
                + productCategory
                + '\''
                + ", disableReason='"
                + disableReason
                + '\''
                + ", extendData="
                + extendData
                + '}';
    }
}
