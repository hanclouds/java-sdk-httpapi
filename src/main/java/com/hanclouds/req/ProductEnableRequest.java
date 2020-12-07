package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 产品启用
 * @author czl
 * @version 1.0
 * @date 2018/4/28 22:20
 */
public class ProductEnableRequest extends AbstractProductKeyRequest<BooleanResponse> {

    public ProductEnableRequest() {
        super("/products/{productKey}/enable");
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
