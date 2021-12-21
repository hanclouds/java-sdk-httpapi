package com.hanclouds.resp;

import lombok.Data;

/**
 * @author xxx
 * @date 2021/12/21 14:28
 */
@Data
public class VideoChannelResponse {
    private String channelId;
    private String sipId;
    private String name;
    private String manufacture;
    private String model;
    private String owner;
    private String civilCode;
    private String block;
    private String address;
    private Integer parental;
    private String parentId;
    private Integer safetyWay;
    private Integer registerWay;
    private String certNum;
    private Integer certifiable;
    private Integer errCode;
    private String endTime;
    private String secrecy;
    private String ipAddress;
    private Integer port;
    private String password;
    private Integer ptzType;
    private Boolean status;
    private Double longitude;
    private Double latitude;
    private Integer subCount;
    private String streamId;
    private Boolean hasAudio;
    private Boolean alive;
    private Boolean cloudRecord;
}
