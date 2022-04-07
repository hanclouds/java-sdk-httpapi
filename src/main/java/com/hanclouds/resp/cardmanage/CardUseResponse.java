package com.hanclouds.resp.cardmanage;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.PageResponse;
import com.hanclouds.model.carmanage.CardInfoDto;
import com.hanclouds.model.carmanage.ProCardInfoListDto;
import com.hanclouds.util.FastJsonTools;

/**
 * 告警事件列表返回
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class CardUseResponse extends AbstractHttpResponse
{

  private PageResponse<ProCardInfoListDto> pageResponse;

  public PageResponse<ProCardInfoListDto> getPageResponse() {
    return pageResponse;
  }

  public void setPageResponse(PageResponse<ProCardInfoListDto> pageResponse) {
    this.pageResponse = pageResponse;
  }

  @Override
  public void parseBaseHttpResponse() {
    BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
    if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
      return;
    }

    this.pageResponse =
        FastJsonTools.getPage(new String(baseHttpResponse.getBodyContent()), ProCardInfoListDto.class);
  }
}
