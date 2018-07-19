package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DataStreamDTO;
import com.hanclouds.model.DeviceArchiveModelDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.util.FastJsonTools;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 15:15
 */
public class DataStreamPageResponse extends AbstractHttpResponse {
    private PageResponse<DataStreamDTO> pageResponse;

    public PageResponse<DataStreamDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<DataStreamDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), DataStreamDTO.class);
    }
}
