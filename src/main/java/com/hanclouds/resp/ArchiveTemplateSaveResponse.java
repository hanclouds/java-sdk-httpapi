package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ArchiveTemplateSaveRetDTO;

/**
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ArchiveTemplateSaveResponse extends AbstractHttpResponse
{

  private ArchiveTemplateSaveRetDTO response;

  public ArchiveTemplateSaveRetDTO getResponse()
  {
    return response;
  }

  public void setResponse(ArchiveTemplateSaveRetDTO response)
  {
    this.response = response;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    response = JSON.parseObject(baseHttpResponse.getBodyContent(), ArchiveTemplateSaveRetDTO.class);
  }
}
