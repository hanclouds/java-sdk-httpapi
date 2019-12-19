package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.ArchiveListResponse;

/**
 * 查询设备下的所有档案
 *
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveListRequest
    extends AbstractDeviceKeyRequest<ArchiveListResponse>
{

  public ArchiveListRequest() {
    super("/archives/{deviceKey}");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<ArchiveListResponse> getResponseClass() {
    return ArchiveListResponse.class;
  }
}
