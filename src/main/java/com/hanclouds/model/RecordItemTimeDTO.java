package com.hanclouds.model;

/**
 * @Description:设备录像bean
 * @author: sxt
 * @date: 2020年5月8日 下午2:06:54
 */
public class RecordItemTimeDTO {
    private String filePath;
    private String startTime;
    private String endTime;

    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }



}
