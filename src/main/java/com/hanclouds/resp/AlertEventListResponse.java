package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.AlertEventDTO;

import java.util.List;

/**
 * 设备告警事件列表返回
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class AlertEventListResponse extends AbstractHttpResponse
{

  private List<AlertEventDTO> response;

  public List<AlertEventDTO> getResponse() {
    return response;
  }

  public void setResponse(List<AlertEventDTO> response) {
    this.response = response;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    this.response =
        JSON.parseArray(new String(baseHttpResponse.getBodyContent()), AlertEventDTO.class);
  }
}
