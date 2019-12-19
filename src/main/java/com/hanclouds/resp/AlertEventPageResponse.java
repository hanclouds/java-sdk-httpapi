package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.AlertEventDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.util.FastJsonTools;

/**
 * 告警事件列表返回
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class AlertEventPageResponse extends AbstractHttpResponse
{

  private PageResponse<AlertEventDTO> pageResponse;

  public PageResponse<AlertEventDTO> getPageResponse() {
    return pageResponse;
  }

  public void setPageResponse(PageResponse<AlertEventDTO> pageResponse) {
    this.pageResponse = pageResponse;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    this.pageResponse =
        FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), AlertEventDTO.class);
  }
}
