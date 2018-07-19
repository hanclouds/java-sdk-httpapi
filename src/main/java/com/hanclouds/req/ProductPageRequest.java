package com.hanclouds.req;

import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.resp.ProductPageResponse;

/**
 * 产品列表请求
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class ProductPageRequest extends AbstractHttpPageRequest<ProductPageResponse> {

    public ProductPageRequest() {
        super("/products");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<ProductPageResponse> getResponseClass() {
        return ProductPageResponse.class;
    }

    @Override
    public void validate() { }
}
