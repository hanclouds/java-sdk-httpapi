package com.hanclouds.req;

import com.hanclouds.enums.EventTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractAlertEventIdentifierPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.AlertEventPageResponse;
import com.hanclouds.util.ValidateUtils;

/**
 * 某个设备的告警事件列表请求(需要分页)
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class AlertEventPageRequest
    extends AbstractAlertEventIdentifierPageRequest<AlertEventPageResponse>
{

  private Long startTime;
  private Long endTime;
  private EventTypeEnum eventType;

  public Long getStartTime() {
    return startTime;
  }

  public void setStartTime(Long startTime) {
    this.startTime = startTime;
    this.putQueryParameter("startTime", String.valueOf(startTime));
  }

  public Long getEndTime() {
    return endTime;
  }

  public void setEndTime(Long endTime) {
    this.endTime = endTime;
    this.putQueryParameter("endTime", String.valueOf(endTime));
  }

  public EventTypeEnum getEventType() {
    return eventType;
  }

  public void setEventType(EventTypeEnum eventType) {
    this.eventType = eventType;
    this.putQueryParameter("eventType", String.valueOf(eventType));
  }

  public AlertEventPageRequest() {
    super("/devices/{deviceKey}/alertEvents/{eventIdentifier}/data");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<AlertEventPageResponse> getResponseClass() {
    return AlertEventPageResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    super.validate();
    ValidateUtils.validatePage(this.page, this.pageSize);
  }
}
