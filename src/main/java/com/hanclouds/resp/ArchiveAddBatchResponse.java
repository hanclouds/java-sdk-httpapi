package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ArchiveAddRetDTO;
import lombok.Data;

import java.util.List;

/**
 * 批量添加档案返回结果
 * @author majiwei
 * @date 2019/10/22
 */
@Data
public class ArchiveAddBatchResponse extends AbstractHttpResponse
{
    private List<ArchiveAddRetDTO> response;

    public List<ArchiveAddRetDTO> getResponse() {
        return response;
    }

    public void setResponse(List<ArchiveAddRetDTO> response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response =
                JSON.parseArray(new String(baseHttpResponse.getBodyContent()), ArchiveAddRetDTO.class);
    }
}
