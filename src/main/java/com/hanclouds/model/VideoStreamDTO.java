package com.hanclouds.model;

import com.alibaba.fastjson.JSONArray;

/**
 * 视频流DTO
 * @author huyunsen
 * @date 2021/11/12 17:31
 */
public class VideoStreamDTO {
    private String flv;
    private String https_flv;
    private String ws_flv;
    private String wss_flv;
    private String fmp4;
    private String https_fmp4;
    private String ws_fmp4;
    private String wss_fmp4;
    private String hls;
    private String https_hls;
    private String ws_hls;
    private String wss_hls;
    private String ts;
    private String https_ts;
    private String ws_ts;
    private String wss_ts;
    private String rtmp;
    private String rtmps;
    private String rtsp;
    private String rtsps;
    private String rtc;


    public String getFlv() {
        return flv;
    }

    public void setFlv(String flv) {
        this.flv = flv;
    }

    public String getHttps_flv() {
        return https_flv;
    }

    public void setHttps_flv(String https_flv) {
        this.https_flv = https_flv;
    }

    public String getWs_flv() {
        return ws_flv;
    }

    public void setWs_flv(String ws_flv) {
        this.ws_flv = ws_flv;
    }

    public String getWss_flv() {
        return wss_flv;
    }

    public void setWss_flv(String wss_flv) {
        this.wss_flv = wss_flv;
    }

    public String getFmp4() {
        return fmp4;
    }

    public void setFmp4(String fmp4) {
        this.fmp4 = fmp4;
    }

    public String getHttps_fmp4() {
        return https_fmp4;
    }

    public void setHttps_fmp4(String https_fmp4) {
        this.https_fmp4 = https_fmp4;
    }

    public String getWs_fmp4() {
        return ws_fmp4;
    }

    public void setWs_fmp4(String ws_fmp4) {
        this.ws_fmp4 = ws_fmp4;
    }

    public String getWss_fmp4() {
        return wss_fmp4;
    }

    public void setWss_fmp4(String wss_fmp4) {
        this.wss_fmp4 = wss_fmp4;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public String getHttps_hls() {
        return https_hls;
    }

    public void setHttps_hls(String https_hls) {
        this.https_hls = https_hls;
    }

    public String getWs_hls() {
        return ws_hls;
    }

    public void setWs_hls(String ws_hls) {
        this.ws_hls = ws_hls;
    }

    public String getWss_hls() {
        return wss_hls;
    }

    public void setWss_hls(String wss_hls) {
        this.wss_hls = wss_hls;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getHttps_ts() {
        return https_ts;
    }

    public void setHttps_ts(String https_ts) {
        this.https_ts = https_ts;
    }

    public String getWs_ts() {
        return ws_ts;
    }

    public void setWs_ts(String ws_ts) {
        this.ws_ts = ws_ts;
    }

    public String getWss_ts() {
        return wss_ts;
    }

    public void setWss_ts(String wss_ts) {
        this.wss_ts = wss_ts;
    }

    public String getRtmp() {
        return rtmp;
    }

    public void setRtmp(String rtmp) {
        this.rtmp = rtmp;
    }

    public String getRtmps() {
        return rtmps;
    }

    public void setRtmps(String rtmps) {
        this.rtmps = rtmps;
    }

    public String getRtsp() {
        return rtsp;
    }

    public void setRtsp(String rtsp) {
        this.rtsp = rtsp;
    }

    public String getRtsps() {
        return rtsps;
    }

    public void setRtsps(String rtsps) {
        this.rtsps = rtsps;
    }

    public String getRtc() {
        return rtc;
    }

    public void setRtc(String rtc) {
        this.rtc = rtc;
    }

    @Override
    public String toString() {
        return "VideoStreamDTO{" +
                "flv='" + flv + '\'' +
                ", https_flv='" + https_flv + '\'' +
                ", ws_flv='" + ws_flv + '\'' +
                ", wss_flv='" + wss_flv + '\'' +
                ", fmp4='" + fmp4 + '\'' +
                ", https_fmp4='" + https_fmp4 + '\'' +
                ", ws_fmp4='" + ws_fmp4 + '\'' +
                ", wss_fmp4='" + wss_fmp4 + '\'' +
                ", hls='" + hls + '\'' +
                ", https_hls='" + https_hls + '\'' +
                ", ws_hls='" + ws_hls + '\'' +
                ", wss_hls='" + wss_hls + '\'' +
                ", ts='" + ts + '\'' +
                ", https_ts='" + https_ts + '\'' +
                ", ws_ts='" + ws_ts + '\'' +
                ", wss_ts='" + wss_ts + '\'' +
                ", rtmp='" + rtmp + '\'' +
                ", rtmps='" + rtmps + '\'' +
                ", rtsp='" + rtsp + '\'' +
                ", rtsps='" + rtsps + '\'' +
                ", rtc='" + rtc + '\'' +
                '}';
    }
}
