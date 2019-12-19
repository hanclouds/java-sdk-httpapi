package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.DeviceArchiveFieldDTO;
import com.hanclouds.resp.DeviceArchiveRecordUptResponse;
import com.hanclouds.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/28 18:59
 */
@Deprecated
public class DeviceArchiveRecordUptRequest extends AbstractDeviceKeyRequest<DeviceArchiveRecordUptResponse> {

    private Map<String, String> propertyData;

    public Map<String, String> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Map<String, String> propertyData) {
        this.propertyData = propertyData;
    }

    public DeviceArchiveRecordUptRequest() {
        super("/devices/{deviceKey}/archiveRecord");
        this.setHttpMethod(HttpMethodEnum.PUT);
    }

    @Override
    public Class<DeviceArchiveRecordUptResponse> getResponseClass() {
        return DeviceArchiveRecordUptResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {

        super.validate();

        if (StringUtils.isBlank(deviceKey)) {
            throw new HanCloudsClientException("deviceKey can not null or empty");
        }
        this.setBodyContentByObject(this.propertyData);
    }
}
