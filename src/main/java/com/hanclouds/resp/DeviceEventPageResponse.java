package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceEventDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.util.FastJsonTools;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 13:01
 */
public class DeviceEventPageResponse extends AbstractHttpResponse {

    private PageResponse<DeviceEventDTO> pageResponse;

    public PageResponse<DeviceEventDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<DeviceEventDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), DeviceEventDTO.class);
    }
}
