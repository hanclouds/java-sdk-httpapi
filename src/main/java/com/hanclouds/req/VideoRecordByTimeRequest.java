package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.VideoStreamResponse;

/**
 * @author xxx
 * @date 2021/11/12 17:43
 */
public class VideoRecordByTimeRequest extends AbstractDeviceKeyRequest<VideoStreamResponse> {
    private String sipId;

    private String channelId;

    private String startTime;

    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
        this.putQueryParameter("startTime",startTime);
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
        this.putQueryParameter("endTime",endTime);
    }

    public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
        this.putQueryParameter("sipId",sipId);
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
        this.putQueryParameter("channelId",channelId);
    }

    public VideoRecordByTimeRequest() {
        super("/videos/{deviceKey}/startVideoBackByTime");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<VideoStreamResponse> getResponseClass() {
        return VideoStreamResponse.class;
    }
}
