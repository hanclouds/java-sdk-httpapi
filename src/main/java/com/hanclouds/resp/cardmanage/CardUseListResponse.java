package com.hanclouds.resp.cardmanage;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceDataDTO;
import com.hanclouds.model.carmanage.ProCardInfoListDto;
import com.hanclouds.model.carmanage.ProCardInfoListIdDto;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 物联卡使用情况
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class CardUseListResponse extends AbstractHttpResponse {

    private List<ProCardInfoListIdDto> response;

    public List<ProCardInfoListIdDto> getResponse() {
        return response;
    }

    public void setResponse(List<ProCardInfoListIdDto> response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }
        List<ProCardInfoListIdDto> list = new ArrayList<ProCardInfoListIdDto>();
        List<ProCardInfoListDto> proCardInfoListDtos = JSON.parseArray(new String(baseHttpResponse.getBodyContent()), ProCardInfoListDto.class);
        for(ProCardInfoListDto dto : proCardInfoListDtos){
            ProCardInfoListIdDto idDto = new ProCardInfoListIdDto();
            BeanUtils.copyProperties(dto,idDto,"id");
            list.add(idDto);
        }
        if(list.size()>0){
            this.response=list;
        }
    }
}
