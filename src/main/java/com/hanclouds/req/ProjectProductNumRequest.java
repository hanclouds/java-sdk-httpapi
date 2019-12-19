package com.hanclouds.req;

import com.hanclouds.http.AbstractProjectKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.IntegerResponse;

/**
 * 查询项目下的产品数请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectProductNumRequest extends AbstractProjectKeyRequest<IntegerResponse>
{

  public ProjectProductNumRequest() {
    super("/projects/{projectKey}/productNum");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<IntegerResponse> getResponseClass() {
    return IntegerResponse.class;
  }
}
