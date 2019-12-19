package com.hanclouds.http;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.util.StringUtils;

/**
 * @author majiwei
 * @date 2019/7/30
 */
public abstract class AbstractDeviceKeyIdentifierRequest<T extends AbstractHttpResponse>
    extends AbstractHttpRequest<T>
{

  protected String deviceKey;
  /** 设备命令模板标识 */
  protected String identifier;

  public AbstractDeviceKeyIdentifierRequest(String url) {
    super(url);
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

  @Override
  public void validate() throws HanCloudsClientException
  {
    if (StringUtils.isBlank(this.deviceKey)) {
      throw new HanCloudsClientException("deviceKey can not null or empty");
    }
    if (StringUtils.isBlank(this.identifier)) {
      throw new HanCloudsClientException("identifier can not null or empty");
    }

    this.setUrl(
        this.getUrl()
            .replace("{deviceKey}", this.deviceKey)
            .replace("{identifier}", this.identifier));
  }
}
