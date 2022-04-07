package com.hanclouds.resp.cardmanage;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceDataDTO;
import com.hanclouds.model.carmanage.ProCardInfoListDto;

import java.util.List;

/**
 * 物联卡使用情况
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class CardUseListResponse extends AbstractHttpResponse {

    private List<ProCardInfoListDto> response;

    public List<ProCardInfoListDto> getResponse() {
        return response;
    }

    public void setResponse(List<ProCardInfoListDto> response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response = JSON.parseArray(new String(baseHttpResponse.getBodyContent()), ProCardInfoListDto.class);
    }
}
