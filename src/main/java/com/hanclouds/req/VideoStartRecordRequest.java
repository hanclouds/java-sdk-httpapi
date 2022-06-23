package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * @author xxx
 * @date 2021/11/12 18:03
 */
public class VideoStartRecordRequest extends AbstractDeviceKeyRequest<BooleanResponse> {
    private String streamId;

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
        this.putQueryParameter("streamId",streamId);
    }

    public VideoStartRecordRequest() {
        super("/videos/{deviceKey}/startRecord");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
