package com.hanclouds.req;

import com.hanclouds.enums.EventTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractAlertEventIdentifierRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.AlertEventListResponse;
import com.hanclouds.util.StringUtils;

/**
 * 某个设备的最近的告警事件列表请求
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class AlertEventListRequest
    extends AbstractAlertEventIdentifierRequest<AlertEventListResponse>
{
  /** 查询的起始时间 */
  private Long startTime;

  /** 查询数据条数（最近多少条） */
  private Integer limit;

  /** 排序字段 asc/desc */
  private String order;

  /** 事件类型 */
  private EventTypeEnum eventType;

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
    this.putQueryParameter("limit", String.valueOf(limit));
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
    this.putQueryParameter("order", order);
  }

  public Long getStartTime()
  {
    return startTime;
  }

  public void setStartTime(Long startTime)
  {
    this.startTime = startTime;
    if(startTime != null){
      this.putQueryParameter("startTime", startTime.toString());
    }
  }

  public EventTypeEnum getEventType() {
    return eventType;
  }

  public void setEventType(EventTypeEnum eventType) {
    this.eventType = eventType;
    this.putQueryParameter("eventType", String.valueOf(eventType));
  }

  public AlertEventListRequest() {
    super("/devices/{deviceKey}/alertEvents/{eventIdentifier}/latestData");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<AlertEventListResponse> getResponseClass() {
    return AlertEventListResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    super.validate();

    if (!StringUtils.isEmpty(this.order)
        && !"asc".toLowerCase().equals(this.order.toLowerCase())
        && !"desc".toLowerCase().equals(this.order.toLowerCase())) {
      throw new HanCloudsClientException("order must be asc or desc");
    }

    if(this.startTime != null && this.startTime <= 0) {
      throw new HanCloudsClientException("startTime must greater than zero");
    }
  }
}
