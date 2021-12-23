package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * @author xxx
 * @date 2021/11/12 18:03
 */
public class VideoSyncChannelRequest extends AbstractDeviceKeyRequest<BooleanResponse> {

    public VideoSyncChannelRequest() {
        super("/videos/{deviceKey}/syncChannel");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
