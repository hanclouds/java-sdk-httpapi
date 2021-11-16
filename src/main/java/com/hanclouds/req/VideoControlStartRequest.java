package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * @author xxx
 * @date 2021/11/12 18:03
 */
public class VideoControlStartRequest extends AbstractDeviceKeyRequest<BooleanResponse> {
    private String sipId;

    private String channelId;

    public String getSipId() {
        return sipId;
    }

    private String command;

    private String speed;

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

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
        this.putQueryParameter("command",command);
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
        this.putQueryParameter("speed",speed);
    }

    public VideoControlStartRequest() {
        super("/videos/{deviceKey}/ptzCmdStart");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
