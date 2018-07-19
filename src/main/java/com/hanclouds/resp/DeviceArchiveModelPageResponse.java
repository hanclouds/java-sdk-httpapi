package com.hanclouds.resp;


import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceArchiveModelDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.util.FastJsonTools;


/**
 * @author lih
 * @version 1.0
 * @date 2018/5/22 21:04
 */
public class DeviceArchiveModelPageResponse extends AbstractHttpResponse {

    private PageResponse<DeviceArchiveModelDTO> pageResponse;

    public PageResponse<DeviceArchiveModelDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<DeviceArchiveModelDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }
        pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), DeviceArchiveModelDTO.class);
    }
}
