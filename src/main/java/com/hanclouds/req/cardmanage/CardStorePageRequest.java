package com.hanclouds.req.cardmanage;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.cardmanage.MapResponse;
import com.hanclouds.util.ValidateUtils;

/**
 * 某个设备的告警事件列表请求(需要分页)
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class CardStorePageRequest
    extends AbstractHttpPageRequest<MapResponse>
{

  protected String msisdns;
  protected String iccid;
  protected String offeringId;

  public String getMsisdns() {
    return msisdns;
  }

  public void setMsisdns(String msisdns) {
    this.msisdns = msisdns;
    this.putQueryParameter("msisdns", String.valueOf(msisdns));
  }

  public String getIccid() {
    return iccid;
  }

  public void setIccid(String iccid) {
    this.iccid = iccid;
    this.putQueryParameter("iccid", String.valueOf(iccid));
  }

  public String getOfferingId() {
    return offeringId;
  }

  public void setOfferingId(String offeringId) {
    this.offeringId = offeringId;
    this.putQueryParameter("offeringId", String.valueOf(offeringId));
  }


  public CardStorePageRequest() {
    super("/openapi/v1/getCardInfoList");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<MapResponse> getResponseClass() {
    return MapResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    ValidateUtils.validatePage(this.page, this.pageSize);
  }
}
