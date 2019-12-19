package com.hanclouds.req;

import com.hanclouds.http.AbstractProjectKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ProjectDetailResponse;

/**
 * 查询项目详情请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectDetailRequest extends AbstractProjectKeyRequest<ProjectDetailResponse>
{

  public ProjectDetailRequest() {
    super("/projects/{projectKey}");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<ProjectDetailResponse> getResponseClass() {
    return ProjectDetailResponse.class;
  }
}
