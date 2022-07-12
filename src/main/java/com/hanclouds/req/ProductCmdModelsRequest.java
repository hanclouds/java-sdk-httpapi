package com.hanclouds.req;

import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ProductCmdModelsResponse;

/**
 * 某个产品的设备列表请求
 * @author czl
 * @version 1.0
 * @date 2018/4/28 16:35
 */
public class ProductCmdModelsRequest extends AbstractProductKeyRequest<ProductCmdModelsResponse> {

    public ProductCmdModelsRequest() {
        super("/devices/{productKey}/getCommandModels");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<ProductCmdModelsResponse> getResponseClass() {
        return ProductCmdModelsResponse.class;
    }

}
