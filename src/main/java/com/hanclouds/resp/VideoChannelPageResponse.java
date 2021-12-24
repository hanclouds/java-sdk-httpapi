package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.PageResponse;
import com.hanclouds.model.VideoChannelDTO;
import com.hanclouds.util.FastJsonTools;

/**
 * @author 胡云森
 * @date 2021/12/21 15:45
 */
public class VideoChannelPageResponse extends AbstractHttpResponse {
    private PageResponse<VideoChannelDTO> pageResponse;

    public PageResponse<VideoChannelDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<VideoChannelDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }
        this.pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()),VideoChannelDTO.class);
    }
}
