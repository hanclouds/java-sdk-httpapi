package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProjectKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ArchiveTemplatePageResponse;
import com.hanclouds.util.StringUtils;

/**
 * 分页查询档案模板
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveTemplatePageRequest
    extends AbstractProjectKeyPageRequest<ArchiveTemplatePageResponse>
{
    /** 档案模板名称,查询的筛选条件,左匹配模糊 */
    private String modelName;

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
        if(StringUtils.isNotEmpty(modelName)){
            this.putQueryParameter("modelName", modelName);
        }
    }

  public ArchiveTemplatePageRequest() {
    super("/archives/template/{projectKey}");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<ArchiveTemplatePageResponse> getResponseClass() {
    return ArchiveTemplatePageResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    super.validate();

    if (page != null && this.page <= 0) {
      throw new HanCloudsClientException("page must greater than zero");
    }
    if (pageSize != null && this.pageSize <= 0) {
      throw new HanCloudsClientException("pageSize must greater than zero");
    }
  }
}
