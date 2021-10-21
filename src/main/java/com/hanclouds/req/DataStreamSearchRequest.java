package com.hanclouds.req;

import com.hanclouds.http.AbstractProductKeyDataStreamRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DataStreamPageResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 15:22
 * 通过dataName左匹配模糊查询
 */
public class DataStreamSearchRequest extends AbstractProductKeyDataStreamRequest<DataStreamPageResponse> {

    public DataStreamSearchRequest() {
        super("/products/{productKey}/datastreams/search/{dataName}");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DataStreamPageResponse> getResponseClass() {
        return DataStreamPageResponse.class;
    }

}
