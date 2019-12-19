package com.hanclouds.req;

import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ProjectListResponse;

/**
 * 查询用户下的項目列表请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectListRequest extends AbstractHttpPageRequest<ProjectListResponse>
{

  public ProjectListRequest() {
    super("/projects");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<ProjectListResponse> getResponseClass() {
    return ProjectListResponse.class;
  }

  @Override
  public void validate() {}
}
