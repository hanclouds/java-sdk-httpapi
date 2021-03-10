package com.hanclouds.req;

import com.hanclouds.enums.CommandStateEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyPageRequest;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceCommandPageResponse;
import com.hanclouds.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备命令查询
 * @author czl
 * @version 1.0
 * @date 2018/4/30 10:05
 */
public class DeviceCommandPageRequest extends AbstractDeviceKeyPageRequest<DeviceCommandPageResponse> {

    private List<CommandStateEnum> states;
    private Long startTime;
    private Long endTime;

    public DeviceCommandPageRequest() {
        super("/devices/{deviceKey}/commands");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    public List<CommandStateEnum> getStates() {
        return states;
    }

    public void setStates(List<CommandStateEnum> states) {
        this.states = states;
        if (states != null && !states.isEmpty()) {
            String[] strStats = new String[states.size()];
            int i = 0;
            for (CommandStateEnum state : states) {
                strStats[i] = state.toString();
                i++;
            }

            this.putQueryParameter("states", strStats);
        } else {
            this.putQueryParameter("states", "");
        }
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
        this.putQueryParameter("startTime", startTime.toString());
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
        this.putQueryParameter("endTime", endTime.toString());
    }

    @Override
    public Class<DeviceCommandPageResponse> getResponseClass() {
        return DeviceCommandPageResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {

        super.validate();

        if (this.page <= 0) {
            throw new HanCloudsClientException("page must greater than zero");
        }
        if (this.pageSize <= 0) {
            throw new HanCloudsClientException("pageSize must greater than zero");
        }
    }
}
