package com.hanclouds.http;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.util.StringUtils;

/**
 * @author majiwei
 * @version 2.0
 * @date 2019/7/26
 */
public abstract class AbstractProjectKeyRequest<T extends AbstractHttpResponse>
    extends AbstractHttpRequest<T>
{

  protected String projectKey;

  public AbstractProjectKeyRequest(String url) {
    super(url);
  }

  public String getProjectKey() {
    return projectKey;
  }

  public void setProjectKey(String projectKey) {
    this.projectKey = projectKey;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    if (StringUtils.isBlank(this.projectKey)) {
      throw new HanCloudsClientException("projectKey can not be null or empty");
    }

    this.setUrl(this.getUrl().replace("{projectKey}", this.projectKey));
  }
}
