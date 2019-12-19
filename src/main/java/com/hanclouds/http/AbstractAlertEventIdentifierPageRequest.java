package com.hanclouds.http;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.util.StringUtils;

/**
 * @author majiwei
 * @date 2019/7/29
 */
public abstract class AbstractAlertEventIdentifierPageRequest<T extends AbstractHttpResponse>
    extends AbstractHttpPageRequest<T>
{
  protected String eventIdentifier;
  protected String deviceKey;

  public AbstractAlertEventIdentifierPageRequest(String url) {
    super(url);
  }

  public String getEventIdentifier() {
    return eventIdentifier;
  }

  public void setEventIdentifier(String eventIdentifier) {
    this.eventIdentifier = eventIdentifier;
  }

  public String getDeviceKey() {
    return deviceKey;
  }

  public void setDeviceKey(String deviceKey) {
    this.deviceKey = deviceKey;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    if (StringUtils.isBlank(this.deviceKey)) {
      throw new HanCloudsClientException("deviceKey can not be null or empty");
    }
    if (StringUtils.isBlank(this.eventIdentifier)) {
      throw new HanCloudsClientException("eventIdentifier can not be null or empty");
    }

    this.setUrl(
        this.getUrl()
            .replace("{deviceKey}", this.deviceKey)
            .replace("{eventIdentifier}", this.eventIdentifier));
  }
}
