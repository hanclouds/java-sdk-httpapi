package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ArchiveResponse;
import com.hanclouds.util.StringUtils;

/**
 * 查询档案信息
 *
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveByIdRequest
    extends AbstractDeviceKeyRequest<ArchiveResponse>
{
  /** 档案ID */
  private String archiveId;

  public String getArchiveId()
  {
    return archiveId;
  }

  public void setArchiveId(String archiveId)
  {
    this.archiveId = archiveId;
    this.putQueryParameter("archiveId", String.valueOf(archiveId));
  }

  public ArchiveByIdRequest() {
    super("/archives/{deviceKey}/id");
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

    if (StringUtils.isBlank(this.archiveId)) {
      throw new HanCloudsClientException("archiveId can not null or empty");
    }
  }

}
