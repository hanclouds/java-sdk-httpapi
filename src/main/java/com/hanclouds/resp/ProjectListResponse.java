package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ProjectDTO;

import java.util.List;

/**
 * 項目列表返回
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectListResponse extends AbstractHttpResponse
{

  private List<ProjectDTO> response;

  public List<ProjectDTO> getResponse() {
    return response;
  }

  public void setResponse(List<ProjectDTO> response) {
    this.response = response;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    this.response =
        JSON.parseArray(new String(baseHttpResponse.getBodyContent()), ProjectDTO.class);
  }
}
