package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

import java.util.List;

/**
 * 批量删除设备档案信息
 *
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveDeleteRequest
    extends AbstractDeviceKeyRequest<BooleanResponse>
{
  /** 待删除的档案ID列表 */
  private List<String> archiveIdList;

  public List<String> getArchiveIdList()
  {
    return archiveIdList;
  }

  public void setArchiveIdList(List<String> archiveIdList)
  {
    this.archiveIdList = archiveIdList;
  }

  public ArchiveDeleteRequest() {
    super("/archives/{deviceKey}/batch");
    this.setHttpMethod(HttpMethodEnum.DELETE);
  }

  @Override
  public Class<BooleanResponse> getResponseClass() {
    return BooleanResponse.class;
  }

  @Override
  public void validate()  throws HanCloudsClientException
  {
    super.validate();

    if (this.archiveIdList == null || this.archiveIdList.size() == 0) {
      throw new HanCloudsClientException("archiveIdList can not null or empty");
    }

    setBodyContentByObject(archiveIdList);
  }

}
