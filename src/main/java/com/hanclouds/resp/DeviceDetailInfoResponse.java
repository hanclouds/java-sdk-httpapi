package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceDetailDTO;

/**
 * 设备信息
 * @author majiwei
 * @date 2019/12/10
 */
public class DeviceDetailInfoResponse extends AbstractHttpResponse
{

  private DeviceDetailDTO response;

  public DeviceDetailDTO getResponse() {
    return response;
  }

  public void setResponse(DeviceDetailDTO response) {
    this.response = response;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    response = JSON.parseObject(baseHttpResponse.getBodyContent(), DeviceDetailDTO.class);
  }
}
