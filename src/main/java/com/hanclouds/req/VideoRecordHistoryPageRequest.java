package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.VideoRecordHistoryPageResponse;
/**
 * @author huyunsen
 * @date 2021/11/12 17:43
 */
public class VideoRecordHistoryPageRequest extends AbstractDeviceKeyRequest<VideoRecordHistoryPageResponse> {
    private String sipId;

    private String channelId;

    private String startTime;

    private String endTime;

    private Integer page;
    private Integer pageSize;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        this.putQueryParameter("page",page.toString());
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.putQueryParameter("pageSize",pageSize.toString());
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
        this.putQueryParameter("startTime",startTime);
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
        this.putQueryParameter("endTime",endTime);
    }

    public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
        this.putQueryParameter("sipId",sipId);
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
        this.putQueryParameter("channelId",channelId);
    }

    public VideoRecordHistoryPageRequest() {
        super("/videos/{deviceKey}/queryRecordList");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<VideoRecordHistoryPageResponse> getResponseClass() {
        return VideoRecordHistoryPageResponse.class;
    }
}
