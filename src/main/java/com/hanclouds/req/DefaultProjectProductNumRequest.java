package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.IntegerResponse;

/**
 * 默认项目下的产品数请求
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
@Deprecated
public class DefaultProjectProductNumRequest extends AbstractHttpPageRequest<IntegerResponse>
{

  public DefaultProjectProductNumRequest() {
    super("/projects/defaultProject/productNum");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<IntegerResponse> getResponseClass() {
    return IntegerResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {}
}
