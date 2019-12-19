package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ArchiveResponse;

/**
 * 查询档案信息
 *
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveByTemplateIdRequest
    extends AbstractDeviceKeyRequest<ArchiveResponse>
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
        this.putQueryParameter("templateId", String.valueOf(templateId));
    }

    public ArchiveByTemplateIdRequest() {
    super("/archives/{deviceKey}/template");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<ArchiveResponse> getResponseClass() {
    return ArchiveResponse.class;
  }

  @Override
  public void validate()  throws HanCloudsClientException
  {
    super.validate();

    if (this.templateId == null || this.templateId <= 0) {
      throw new HanCloudsClientException("templateId can not null or less than zero");
    }
  }

}
