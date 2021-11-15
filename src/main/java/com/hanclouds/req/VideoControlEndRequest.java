package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * @author xxx
 * @date 2021/11/12 18:03
 */
public class VideoControlEndRequest extends AbstractDeviceKeyRequest<BooleanResponse> {
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

    public VideoControlEndRequest() {
        super("/videos/{deviceKey}/ptzCmdEnd");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
