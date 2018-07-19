package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.model.PageResponse;
import com.hanclouds.model.ProductDTO;
import com.hanclouds.util.FastJsonTools;


/**
 * 产品列表返回
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class ProductPageResponse extends AbstractHttpResponse {

    private PageResponse<ProductDTO> pageResponse;

    public PageResponse<ProductDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse<ProductDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.pageResponse = FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), ProductDTO.class);
    }
}
