package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceDTO;

/**
 * 设备信息
 * @author majiwei
 * @date 2019/12/10
 */
public class DeviceInfoResponse extends AbstractHttpResponse
{

  private DeviceDTO response;

  public DeviceDTO getResponse() {
    return response;
  }

  public void setResponse(DeviceDTO response) {
    this.response = response;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    response = JSON.parseObject(baseHttpResponse.getBodyContent(), DeviceDTO.class);
  }
}
