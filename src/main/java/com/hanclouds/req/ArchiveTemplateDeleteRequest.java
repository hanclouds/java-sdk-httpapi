package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 删除档案模板请求
 *
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveTemplateDeleteRequest
    extends AbstractHttpRequest<BooleanResponse>
{
  /** 档案模板ID */
  private Integer templateId;

  public Integer getTemplateId()
  {
    return templateId;
  }

  public void setTemplateId(Integer templateId)
  {
    this.templateId = templateId;
  }

  public ArchiveTemplateDeleteRequest() {
    super("/archives/template/{templateId}");
    this.setHttpMethod(HttpMethodEnum.DELETE);
  }

  @Override
  public Class<BooleanResponse> getResponseClass() {
    return BooleanResponse.class;
  }

  @Override
  public void validate()  throws HanCloudsClientException
  {
    if (this.templateId == null || this.templateId <= 0) {
      throw new HanCloudsClientException("templateId can not null or less than zero");
    }

    this.setUrl(this.getUrl().replace("{templateId}", String.valueOf(templateId)));
  }

}
