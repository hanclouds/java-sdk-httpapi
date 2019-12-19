package com.hanclouds.model;

import com.hanclouds.enums.EventTypeEnum;

/**
 * 新增告警事件DTO
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class AlertEventAddDTO {
  private String userKey;
  private String projectKey;
  private String productKey;
  private String output;

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

  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }
}
