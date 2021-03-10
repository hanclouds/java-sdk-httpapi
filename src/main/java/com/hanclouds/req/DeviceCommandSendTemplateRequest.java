package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyIdentifierRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.StringResponse;
import com.hanclouds.util.FastJsonTools;
import com.hanclouds.util.StringUtils;

import java.util.regex.Pattern;

/**
 * 根据命令模板进行设备命令发送 有效时间 有效时间，最长60天，命令的有效时间支持秒（s/S）、分钟（m/M）、小时（h/H）、天（d/D）四种单位，例如3s、5H"
 *
 * @author majiwei
 * @date 2019/7/31
 */
public class DeviceCommandSendTemplateRequest
    extends AbstractDeviceKeyIdentifierRequest<StringResponse>
{

  private String content;
  private Integer validTime;

  private static final Pattern VALID_TIME_REGEX = Pattern.compile("^[1-9]\\d*[sSmMhHdD]$");
  private static final Integer MIN_VALID_TIME_LENGTH = 2;

  public DeviceCommandSendTemplateRequest() {
    super("/devices/{deviceKey}/commands/{identifier}");
    this.setHttpMethod(HttpMethodEnum.POST);
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getValidTime() {
    return validTime;
  }

  public void setValidTime(Integer validTime) {
    this.validTime = validTime;
    this.putQueryParameter("validTime", validTime.toString());
  }

  @Override
  public Class<StringResponse> getResponseClass() {
    return StringResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    super.validate();
    if (StringUtils.isBlank(content)) {
      throw new HanCloudsClientException("content can not null or empty");
    }

    if (!FastJsonTools.isJsonStrValid(content)) {
      throw new HanCloudsClientException("content字段为JSON字符串格式");
    }
    this.setBodyContentByObject(content);
  }
}
