package com.hanclouds.model;

import java.util.Date;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/28 16:43
 */
public class DeviceDTO {

    private Date createAt;
    private Date updateAt;
    private String deviceKey;
    private String sn;
    private String userKey;
    private String productKey;
    private String productCategory;
    private String deviceType;
    private String descr;
    private Integer createProtocol;
    private Integer deviceStatus;
    private Boolean createAck;
    private Object extendData;
    private String deviceName;
    private Boolean gateway;
    private String gatewayKey;

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey == null ? null : deviceKey.trim();
    }

    public String getSn() {
        return this.sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Integer getCreateProtocol() {
        return this.createProtocol;
    }

    public void setCreateProtocol(Integer createProtocol) {
        this.createProtocol = createProtocol;
    }

    public Integer getDeviceStatus() {
        return this.deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Boolean getCreateAck() {
        return this.createAck;
    }

    public void setCreateAck(Boolean createAck) {
        this.createAck = createAck;
    }

    public Object getExtendData() {
        return this.extendData;
    }

    public void setExtendData(Object extendData) {
        this.extendData = extendData;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getDeviceName() { return deviceName; }

    public void setDeviceName(String deviceName) { this.deviceName = deviceName;}

    public String getProductCategory()
    {
        return productCategory;
    }

    public void setProductCategory(String productCategory)
    {
        this.productCategory = productCategory;
    }

    public Boolean getGateway()
    {
        return gateway;
    }

    public void setGateway(Boolean gateway)
    {
        this.gateway = gateway;
    }

    public String getGatewayKey()
    {
        return gatewayKey;
    }

    public void setGatewayKey(String gatewayKey)
    {
        this.gatewayKey = gatewayKey;
    }

    @Override
    public String toString()
    {
        return "DeviceDTO{" +
                "createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deviceKey='" + deviceKey + '\'' +
                ", sn='" + sn + '\'' +
                ", userKey='" + userKey + '\'' +
                ", productKey='" + productKey + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", descr='" + descr + '\'' +
                ", createProtocol=" + createProtocol +
                ", deviceStatus=" + deviceStatus +
                ", createAck=" + createAck +
                ", extendData=" + extendData +
                ", deviceName='" + deviceName + '\'' +
                ", gateway=" + gateway +
                ", gatewayKey='" + gatewayKey + '\'' +
                '}';
    }
}
