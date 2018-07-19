package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.UserDTO;

/**
 * 用户数据
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class UserResponse extends AbstractHttpResponse {

    private UserDTO response;

    public UserDTO getResponse() {
        return response;
    }

    public void setResponse(UserDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response = JSON.parseObject(baseHttpResponse.getBodyContent(), UserDTO.class);
    }
}
