package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ArchiveTemplateDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.util.FastJsonTools;

/**
 * 分页查询档案模板信息响应
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveTemplatePageResponse extends AbstractHttpResponse {
    private PageResponse<ArchiveTemplateDTO> pageResponse;

    public PageResponse<ArchiveTemplateDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<ArchiveTemplateDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.pageResponse =
                FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), ArchiveTemplateDTO.class);
    }
}
