package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 产品禁用
 * @author czl
 * @version 1.0
 * @date 2018/4/28 22:20
 */
public class ProductDisableRequest extends AbstractProductKeyRequest<BooleanResponse> {

    public ProductDisableRequest() {
        super("/products/{productKey}/disable");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException{
        super.validate();
    }
}
