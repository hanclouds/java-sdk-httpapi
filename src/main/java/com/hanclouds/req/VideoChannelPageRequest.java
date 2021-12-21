package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.VideoChannelPageResponse;

/**
 * @author xxx
 * @date 2021/12/21 15:53
 */
public class VideoChannelPageRequest extends AbstractDeviceKeyPageRequest<VideoChannelPageResponse> {
    private String sipId;

    public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
        this.putQueryParameter("sipId",sipId);
    }

    public VideoChannelPageRequest() {
        super("/videos/{deviceKey}/streamStart");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<VideoChannelPageResponse> getResponseClass() {
        return VideoChannelPageResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (this.page <= 0) {
            throw new HanCloudsClientException("page must greater than zero");
        }

        if (this.pageSize <= 0) {
            throw new HanCloudsClientException("pageSize must greater than zero");
        }
    }
}
