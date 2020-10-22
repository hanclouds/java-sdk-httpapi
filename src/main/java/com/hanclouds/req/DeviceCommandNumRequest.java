package com.hanclouds.req;

import com.hanclouds.enums.CommandStateEnum;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.LongResponse;

import java.util.List;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/5 17:59
 */
@Deprecated
public class DeviceCommandNumRequest extends AbstractDeviceKeyRequest<LongResponse> {
    private List<CommandStateEnum> states;
    private Long startTime;
    private Long endTime;

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
        if (startTime != null) {
            this.putQueryParameter("startTime", startTime.toString());
        }
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
        if (endTime != null) {
            this.putQueryParameter("endTime", endTime.toString());
        }
    }

    public DeviceCommandNumRequest() {
        super("/devices/{deviceKey}/commandNum");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<LongResponse> getResponseClass() {
        return LongResponse.class;
    }
}
