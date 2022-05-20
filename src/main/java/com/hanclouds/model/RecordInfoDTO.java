package com.hanclouds.model;


import java.util.List;

/**
 * @Description:设备录像信息bean
 * @author: sxt
 * @date: 2020年5月8日 下午2:05:56
 */
public class RecordInfoDTO {

    private String sipId;

    private String channelId;

    private String name;

    private int sumNum;

    private List<RecordItemTimeDTO> recordList;

    public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumNum() {
        return sumNum;
    }

    public void setSumNum(int sumNum) {
        this.sumNum = sumNum;
    }

    public List<RecordItemTimeDTO> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<RecordItemTimeDTO> recordList) {
        this.recordList = recordList;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

}
