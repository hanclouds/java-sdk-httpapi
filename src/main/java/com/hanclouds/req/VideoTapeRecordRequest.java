package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ByteResponse;

/**
 * @author xxx
 * @date 2021/11/12 17:43
 */
public class VideoTapeRecordRequest extends AbstractDeviceKeyRequest<ByteResponse> {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        this.putQueryParameter("path",path);
    }


    public VideoTapeRecordRequest() {
        super("/videos/{deviceKey}/getRecord");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<ByteResponse> getResponseClass() {
        return ByteResponse.class;
    }
}
