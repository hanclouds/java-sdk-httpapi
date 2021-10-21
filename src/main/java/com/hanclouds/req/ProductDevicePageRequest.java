package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DevicePageResponse;

/**
 * 某个产品的设备列表请求
 * @author czl
 * @version 1.0
 * @date 2018/4/28 16:35
 */
public class ProductDevicePageRequest extends AbstractProductKeyPageRequest<DevicePageResponse> {

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setkeyword(String keyword) {
        this.keyword = keyword;
        this.putQueryParameter("keyword",keyword);
    }

    public ProductDevicePageRequest() {
        super("/products/{productKey}/devices");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DevicePageResponse> getResponseClass() {
        return DevicePageResponse.class;
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
