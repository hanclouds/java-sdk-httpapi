package com.hanclouds.req;

import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.StringResponse;
import com.hanclouds.util.SdkRegexUtils;
import com.hanclouds.util.StringUtils;

import java.util.regex.Pattern;


/**
 * 设备命令发送
 * 有效时间 有效时间，最长60天，命令的有效时间支持秒（s/S）、分钟（m/M）、小时（h/H）、天（d/D）四种单位，例如3s、5H"
 * @author czl
 * @version 1.0
 * @date 2018/4/30 9:30
 */
public class DeviceCommandSendRequest extends AbstractDeviceKeyRequest<StringResponse> {

    private DataTypeEnum dataType;
    private String content;
    private Integer validTime;

    private static final Pattern VALID_TIME_REGEX=Pattern.compile("^[1-9]\\d*[sSmMhHdD]$");
    private static final Integer MIN_VALID_TIME_LENGTH=2;



    public DeviceCommandSendRequest() {
        super("/devices/{deviceKey}/commands");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
        this.putQueryParameter("dataType",String.valueOf(dataType.intValue()));
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
        this.putQueryParameter("validTime",validTime.toString());
    }

    @Override
    public Class<StringResponse> getResponseClass() {
        return StringResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (dataType.equals(DataTypeEnum.INVALID)) {
            throw new HanCloudsClientException("data type error");
        }
        if (StringUtils.isBlank(content)) {
            throw new HanCloudsClientException("content can not null or empty");
        }
        SdkRegexUtils.dataFormat(dataType,content);
        this.setBodyContentByObject(content);
    }


}
