package com.hanclouds.req;

import com.alibaba.fastjson.JSON;
import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyDataStreamRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.SdkRegexUtils;
import com.hanclouds.util.StringUtils;

/**
 * 设备上传数据
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:54
 */
public class DeviceDataStreamUploadDataRequest extends AbstractDeviceKeyDataStreamRequest<BooleanResponse> {

    private DataTypeEnum dataType;
    private Object content;

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
        this.putQueryParameter("dataType",String.valueOf(dataType.intValue()));
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public DeviceDataStreamUploadDataRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/data");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (dataType.equals(DataTypeEnum.INVALID)) {
            throw new HanCloudsClientException("data type error");
        }
        if (StringUtils.isBlank(content.toString())) {
            throw new HanCloudsClientException("content can not null or empty");
        }


        SdkRegexUtils.dataFormat(dataType, content.toString());

        // 这里解决content从String变成Object类型之后，String数据http数据格式转换失败的问题
        if(content instanceof String && (dataType.equals(DataTypeEnum.STRING) || dataType.equals(DataTypeEnum.BIN))){
            this.content = JSON.toJSONString(content);
        }
        this.setBodyContentByObject(content);
    }
}
