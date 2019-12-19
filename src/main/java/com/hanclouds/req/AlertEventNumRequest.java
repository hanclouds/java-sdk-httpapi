package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.IntegerResponse;

/**
 * 查询指定设备的告警事件总数
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/29
 */
public class AlertEventNumRequest extends AbstractDeviceKeyRequest<IntegerResponse>
{

  public AlertEventNumRequest() {
    super("/devices/{deviceKey}/alertEventsNum");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<IntegerResponse> getResponseClass() {
    return IntegerResponse.class;
  }
}
