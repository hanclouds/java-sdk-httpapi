package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ProductDTO;

import java.util.List;

/**
 * 获取项目下的所有产品响应
 *
 * @author majiwei
 * @version 2.0
 * @date 2019/7/25
 */
public class ProjectProductListResponse extends AbstractHttpResponse
{
  private List<ProductDTO> response;

  public List<ProductDTO> getResponse() {
    return response;
  }

  public void setResponse(List<ProductDTO> response) {
    this.response = response;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    this.response =
        JSON.parseArray(new String(baseHttpResponse.getBodyContent()), ProductDTO.class);
  }
}
