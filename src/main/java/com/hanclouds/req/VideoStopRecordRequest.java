package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.resp.VideoStopRecordResponse;

/**
 * @author xxx
 * @date 2021/11/12 18:03
 */
public class VideoStopRecordRequest extends AbstractDeviceKeyRequest<VideoStopRecordResponse> {
    private String streamId;

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
        this.putQueryParameter("streamId",streamId);
    }

    public VideoStopRecordRequest() {
        super("/videos/{deviceKey}/stopRecord");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<VideoStopRecordResponse> getResponseClass() {
        return VideoStopRecordResponse.class;
    }
}
