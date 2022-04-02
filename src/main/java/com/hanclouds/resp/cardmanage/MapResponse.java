package com.hanclouds.resp.cardmanage;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.AlertEventDTO;
import com.hanclouds.model.PageResponse;
import com.hanclouds.model.carmanage.CardInfoDto;
import com.hanclouds.util.FastJsonTools;

import java.util.Map;

/**
 * 告警事件列表返回
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class MapResponse extends AbstractHttpResponse
{

  private PageResponse<CardInfoDto> pageResponse;

  public PageResponse<CardInfoDto> getPageResponse() {
    return pageResponse;
  }

  public void setPageResponse(PageResponse<CardInfoDto> pageResponse) {
    this.pageResponse = pageResponse;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    this.pageResponse =
        FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), CardInfoDto.class);
  }
}
