package com.hanclouds.req.cardmanage;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyDataStreamPageRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceDataStreamLatestDataResponse;
import com.hanclouds.resp.cardmanage.CardUseListResponse;
import com.hanclouds.resp.cardmanage.CardUseResponse;
import com.hanclouds.util.StringUtils;

/**
 * 根据数据流名称获取设备最近数据点
 *
 * @author czl
 * @version 1.0
 * @date 2018/4/24 13:46
 */
public class CardUseListRequest extends AbstractHttpRequest<CardUseListResponse> {

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


    public CardUseListRequest() {
        super("/openapi/v1/getCardUseInfoList");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<CardUseListResponse> getResponseClass() {
        return CardUseListResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {


        if(StringUtils.isEmpty(msisdns)) {
            throw new HanCloudsClientException("msisdns must not be null");
        }
    }
}
