package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DataStreamTemplateDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.util.FastJsonTools;

/**
 * 数据流模板响应
 * @author majiwei
 * @date 2019/11/13
 */
public class DataStreamTemplatePageResponse extends AbstractHttpResponse {
    private PageResponse<DataStreamTemplateDTO> pageResponse;

    public PageResponse<DataStreamTemplateDTO> getPageResponse()
    {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<DataStreamTemplateDTO> pageResponse)
    {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), DataStreamTemplateDTO.class);
    }
}
