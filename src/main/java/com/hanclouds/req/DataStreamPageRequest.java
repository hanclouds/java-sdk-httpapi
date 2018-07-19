package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.http.AbstractProductKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DataStreamPageResponse;
import com.hanclouds.util.StringUtils;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 15:15
 */
public class DataStreamPageRequest extends AbstractProductKeyPageRequest<DataStreamPageResponse> {

    public DataStreamPageRequest() {
        super("/products/{productKey}/datastreams");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DataStreamPageResponse> getResponseClass() {
        return DataStreamPageResponse.class;
    }
}
