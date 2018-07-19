package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.model.ProductDTO;
import com.hanclouds.util.FastJsonTools;


/**
 * 设备列表
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class DevicePageResponse extends AbstractHttpResponse {

    private PageResponse<DeviceDTO> pageResponse;

    public PageResponse<DeviceDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<DeviceDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), DeviceDTO.class);
    }
}
