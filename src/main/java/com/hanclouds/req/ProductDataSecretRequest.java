package com.hanclouds.req;

import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.StringResponse;

/**
 * @author http推送秘钥dataSecret查询
 * @date 2022/3/8 11:12
 */
public class ProductDataSecretRequest extends AbstractProductKeyRequest<StringResponse> {
    public ProductDataSecretRequest() {
        super("/products/{productKey}/dataSecret");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<StringResponse> getResponseClass() {
        return StringResponse.class;
    }
}
