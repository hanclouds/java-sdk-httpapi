package com.hanclouds.req;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProjectKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.StringUtils;

/**
 * 项目更新请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectUpdateRequest extends AbstractProjectKeyRequest<BooleanResponse>
{
  private String projectName;
  private String descr;

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public ProjectUpdateRequest() {
    super("/projects/{projectKey}");
    this.setHttpMethod(HttpMethodEnum.PUT);
  }

  @Override
  public Class<BooleanResponse> getResponseClass() {
    return BooleanResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    super.validate();

    if (projectName != null && StringUtils.isBlank(projectName)) {
      throw new HanCloudsClientException("projectName can not be null or empty");
    }
    if (descr != null && StringUtils.isBlank(descr)) {
      throw new HanCloudsClientException("descr can not be null or empty");
    }

    if(descr.length() > 100) {
      throw new HanCloudsClientException("the length of descr can not exceed 100");
    }

    if("project0".equals(projectKey)){
      throw new HanCloudsClientException("the default project cannot be modified");
    }

    SimplePropertyPreFilter filter =
        new SimplePropertyPreFilter(ProjectUpdateRequest.class, "projectName", "descr");
    setBodyContentByObject(filter);
  }
}
