package com.hanclouds.req;

import com.hanclouds.http.AbstractProductKeyDataStreamRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DataStreamResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 15:22
 */
public class DataStreamRequest extends AbstractProductKeyDataStreamRequest<DataStreamResponse> {

    public DataStreamRequest() {
        super("/products/{productKey}/datastreams/{dataName}");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DataStreamResponse> getResponseClass() {
        return DataStreamResponse.class;
    }
}
