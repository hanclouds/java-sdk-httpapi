package com.hanclouds.model;

import java.util.Date;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/28 16:43
 */
public class DeviceDetailDTO {

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
    private Integer deviceCategory;
    private Boolean createAck;
    private Object extendData;
    private String deviceName;
    private Integer gateway;
    private String gatewayKey;
    /**
     * 视频设备sipId
     */
    private String sipId;
    /**
     * 视频设备类型 0 ipc摄像头  1 nvr磁盘
     */
    private Integer monitorType;

    public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public Integer getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(Integer deviceCategory) {
        this.deviceCategory = deviceCategory;
    }
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

    public Integer getGateway()
    {
        return gateway;
    }

    public void setGateway(Integer gateway)
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
