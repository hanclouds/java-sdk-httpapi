package com.hanclouds.req;

import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyDataStreamRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.RegexUtils;
import com.hanclouds.util.StringUtils;

/**
 * 设备上传数据
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:54
 */
public class DeviceDataStreamUploadDataRequest extends AbstractDeviceKeyDataStreamRequest<BooleanResponse> {

    private DataTypeEnum dataType;
    private String content;

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
        if (StringUtils.isBlank(content)) {
            throw new HanCloudsClientException("content can not null or empty");
        }
        RegexUtils.dataFormat(dataType, content);
        this.setBodyContentByObject(content);
    }

}
