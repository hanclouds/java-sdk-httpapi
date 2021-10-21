package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.IntegerResponse;
import com.hanclouds.util.StringUtils;

/**
*  根据用户Key查询在线设备数
 * @author lih
 * @version 1.0
 * @date 2018/6/4 10:21
 */
public class DeviceOnlineByUserKeyRequest extends AbstractHttpRequest<IntegerResponse> {
    private String userKey;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public DeviceOnlineByUserKeyRequest() {
        super("/devices/userKey/{userKey}/findDeviceOnline");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<IntegerResponse> getResponseClass() {
        return IntegerResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        if (StringUtils.isBlank(userKey)) {
            throw new HanCloudsClientException("userKey can not null or empty");
        }
        this.setUrl(
                this.getUrl().replace("{userKey}", userKey));
    }
}
