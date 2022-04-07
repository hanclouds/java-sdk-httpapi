package com.hanclouds.req.cardmanage;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.cardmanage.CardUseResponse;
import com.hanclouds.resp.cardmanage.MapResponse;
import com.hanclouds.util.ValidateUtils;

/**
 * 某个设备的告警事件列表请求(需要分页)
 *
 * @author majiwei
 * @date 2019/7/29
 */
public class CardUsePageRequest
    extends AbstractHttpPageRequest<CardUseResponse>
{

  protected String msisdns;
  protected String cardStatus;
  protected String projectName;
  protected String offeringId;

  public String getMsisdns() {
    return msisdns;
  }

  public void setMsisdns(String msisdns) {
    this.msisdns = msisdns;
    this.putQueryParameter("msisdns", String.valueOf(msisdns));
  }

  public String getCardStatus() {
    return cardStatus;
  }

  public void setCardStatus(String cardStatus) {
    this.cardStatus = cardStatus;
    this.putQueryParameter("cardStatus", String.valueOf(cardStatus));

  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
    this.putQueryParameter("projectName", String.valueOf(projectName));

  }

  public String getOfferingId() {
    return offeringId;
  }

  public void setOfferingId(String offeringId) {
    this.offeringId = offeringId;
    this.putQueryParameter("offeringId", String.valueOf(offeringId));
  }


  public CardUsePageRequest() {
    super("/openapi/v1/getCardUseInfoPage");
    this.setHttpMethod(HttpMethodEnum.GET);
  }

  @Override
  public Class<CardUseResponse> getResponseClass() {
    return CardUseResponse.class;
  }

  @Override
  public void validate() throws HanCloudsClientException
  {
    ValidateUtils.validatePage(this.page, this.pageSize);
  }
}
