package com.hanclouds.req;

import com.hanclouds.http.AbstractProjectKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ProjectProductListResponse;

/**
 * 查询项目下的所有产品请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectProductListRequest
    extends AbstractProjectKeyRequest<ProjectProductListResponse> {

  private String queryAuthType;

  public String getQueryAuthType() {
    return queryAuthType;
  }

  public void setQueryAuthType(String queryAuthType) {
    this.queryAuthType = queryAuthType;
    if (this.queryAuthType != null) {
      this.putQueryParameter("queryAuthTypeEnum", this.queryAuthType);
    }
  }

  public ProjectProductListRequest() {
    super("/projects/{projectKey}/products");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<ProjectProductListResponse> getResponseClass() {
    return ProjectProductListResponse.class;
  }
}
