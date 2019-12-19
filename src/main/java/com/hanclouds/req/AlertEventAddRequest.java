package com.hanclouds.req;

import com.hanclouds.enums.EventTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractAlertEventIdentifierRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.AlertEventAddDTO;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.FastJsonTools;
import com.hanclouds.util.StringUtils;

/**
 * 设备上报（新增）告警事件请求
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class AlertEventAddRequest extends AbstractAlertEventIdentifierRequest<BooleanResponse>
{

  private AlertEventAddDTO alertEventAddDTO;

  public AlertEventAddDTO getAlertEventAddDTO() {
    return alertEventAddDTO;
  }

  public void setAlertEventAddDTO(AlertEventAddDTO alertEventAddDTO) {
    this.alertEventAddDTO = alertEventAddDTO;
  }

  public AlertEventAddRequest() {
    super("/devices/{deviceKey}/alertEvents/{eventIdentifier}/data");
    this.setHttpMethod(HttpMethodEnum.POST);
  }

  @Override
  public Class<BooleanResponse> getResponseClass() {
    return BooleanResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    super.validate();
    if (StringUtils.isBlank(alertEventAddDTO.getUserKey())
        || StringUtils.isBlank(alertEventAddDTO.getProjectKey())
        || StringUtils.isBlank(alertEventAddDTO.getProductKey())
        || alertEventAddDTO.getOutput() == null) {
      throw new HanCloudsClientException("必填参数为空");
    }

    // 校验alertEventAddDTO.getOutput()格式是否为JSON字符串
    if (StringUtils.isNotEmpty(alertEventAddDTO.getOutput())
        && !FastJsonTools.isJsonStrValid(alertEventAddDTO.getOutput())) {
      throw new HanCloudsClientException("output字段为JSON字符串格式");
    }
    this.setBodyContentByObject(this.alertEventAddDTO);
  }
}
