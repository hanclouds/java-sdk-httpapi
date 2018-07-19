package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.model.DeviceDataDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.util.FastJsonTools;

/**
 * 根据数据流名称获取设备数据流返回
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class DeviceDataStreamDataPageResponse extends AbstractHttpResponse {

    private PageResponse<DeviceDataDTO> pageResponse;

    public PageResponse<DeviceDataDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<DeviceDataDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), DeviceDataDTO.class);
    }
}
