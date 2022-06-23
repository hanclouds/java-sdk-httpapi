package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ByteResponse;
import com.hanclouds.resp.VideoStreamResponse;

/**
 * @author xxx
 * @date 2021/11/12 17:43
 */
public class VideoSnapRequest extends AbstractDeviceKeyRequest<ByteResponse> {
    private String streamId;

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
        this.putQueryParameter("streamId",streamId);
    }


    public VideoSnapRequest() {
        super("/videos/{deviceKey}/getSnap");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<ByteResponse> getResponseClass() {
        return ByteResponse.class;
    }
}
