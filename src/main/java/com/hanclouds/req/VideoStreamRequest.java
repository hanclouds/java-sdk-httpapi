package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.VideoStreamResponse;

/**
 * @author xxx
 * @date 2021/11/12 17:43
 */
public class VideoStreamRequest extends AbstractDeviceKeyRequest<VideoStreamResponse> {
    private String sipId;

    private String channelId;

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

    public VideoStreamRequest() {
        super("/videos/{deviceKey}/streamStart");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<VideoStreamResponse> getResponseClass() {
        return VideoStreamResponse.class;
    }
}
