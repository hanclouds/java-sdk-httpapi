package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.LongResponse;
import com.hanclouds.util.StringUtils;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/5 11:31
 */
public class ProductDataTotalNumRequest extends AbstractProductKeyRequest<LongResponse> {

    public ProductDataTotalNumRequest() {
        super("/products/{productKey}/dataTotalNum");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<LongResponse> getResponseClass() {
        return LongResponse.class;
    }
}
