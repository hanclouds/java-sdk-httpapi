package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ArchiveDTO;

import java.util.List;

/**
 * 档案列表响应
 *
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveListResponse extends AbstractHttpResponse
{
  private List<ArchiveDTO> response;

  public List<ArchiveDTO> getResponse() {
    return response;
  }

  public void setResponse(List<ArchiveDTO> response) {
    this.response = response;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    this.response =
        JSON.parseArray(new String(baseHttpResponse.getBodyContent()), ArchiveDTO.class);
  }
}
