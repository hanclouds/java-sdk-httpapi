package com.hanclouds.req;

import com.hanclouds.http.AbstractProjectKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 项目删除请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectDeleteRequest extends AbstractProjectKeyRequest<BooleanResponse>
{

  public ProjectDeleteRequest() {
    super("/projects/{projectKey}");
    this.setHttpMethod(HttpMethodEnum.DELETE);
  }

  @Override
  public Class<BooleanResponse> getResponseClass() {
    return BooleanResponse.class;
  }
}
