package com.hanclouds.req;

import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ProjectProductListResponse;

/**
 * 默认项目下的所有产品请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
@Deprecated
public class DefaultProjectProductListRequest
    extends AbstractHttpPageRequest<ProjectProductListResponse>
{

  public DefaultProjectProductListRequest() {
    super("/projects/defaultProject/products");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<ProjectProductListResponse> getResponseClass() {
    return ProjectProductListResponse.class;
  }

  @Override
  public void validate() {}
}
