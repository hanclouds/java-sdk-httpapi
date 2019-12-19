package com.hanclouds.model;

import com.hanclouds.enums.EventTypeEnum;

/**
 * 告警事件DTO
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class AlertEventDTO {
  private String userKey;
  private String projectKey;
  private String productKey;
  private String deviceKey;
  private String identifier;
  private EventTypeEnum eventTypeEnum;
  private String output;
  private long time;

  public String getUserKey() {
    return userKey;
  }

  public void setUserKey(String userKey) {
    this.userKey = userKey;
  }

  public String getProjectKey() {
    return projectKey;
  }

  public void setProjectKey(String projectKey) {
    this.projectKey = projectKey;
  }

  public String getProductKey() {
    return productKey;
  }

  public void setProductKey(String productKey) {
    this.productKey = productKey;
  }

  public String getDeviceKey() {
    return deviceKey;
  }

  public void setDeviceKey(String deviceKey) {
    this.deviceKey = deviceKey;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public EventTypeEnum getEventTypeEnum() {
    return eventTypeEnum;
  }

  public void setEventTypeEnum(EventTypeEnum eventTypeEnum) {
    this.eventTypeEnum = eventTypeEnum;
  }

  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "AlertEventDTO{"
        + "userKey='"
        + userKey
        + '\''
        + ", projectKey='"
        + projectKey
        + '\''
        + ", productKey='"
        + productKey
        + '\''
        + ", deviceKey='"
        + deviceKey
        + '\''
        + ", identifier='"
        + identifier
        + '\''
        + ", eventTypeEnum="
        + eventTypeEnum
        + ", output="
        + output
        + ", time="
        + time
        + '}';
  }
}
