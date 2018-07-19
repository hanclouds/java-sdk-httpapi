package com.hanclouds.model;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 10:01
 */
public class DeviceCommandDTO {

    /**
     * 命令Id，为命令的唯一标识
     */
    private String cmdId;
    /**
     * 接受此命令的设备deviceKey
     */
    private String deviceKey;
    /**
     * 平台收到命令请求的Timestamp
     */
    private Long timeReq;
    /**
     * 命令的有效截止时间
     */
    private Long timeDue;
    /**
     * 平台把命令下发给设备的时间戳
     */
    private Long timeSend;
    /**
     * 设备回复mqtt ack的响应的时间戳
     */
    private Long timeAck;
    /**
     * 设备把命令处理完成后响应的时间戳。 设备在topic  cmdack/...上下发响应的时间
     */
    private Long timeCpl;
    /**
     * 命令状态
     */
    private Integer state;
    /**
     * 数据类型
     */
    private Integer type;
    /**
     * 数据值，视类型不同，形式有所不同
     * <p>
     * json: 对象{...}
     * <p>
     * int: 整数
     * <p>
     * double: 浮点数
     * <p>
     * string: 字符串
     * <p>
     * bin: 二进制字节数组的Base64编码后的字符串
     */
    private Object data;

    public String getCmdId() {
        return cmdId;
    }

    public void setCmdId(String cmdId) {
        this.cmdId = cmdId;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public Long getTimeReq() {
        return timeReq;
    }

    public void setTimeReq(Long timeReq) {
        this.timeReq = timeReq;
    }

    public Long getTimeDue() {
        return timeDue;
    }

    public void setTimeDue(Long timeDue) {
        this.timeDue = timeDue;
    }

    public Long getTimeSend() {
        return timeSend;
    }

    public void setTimeSend(Long timeSend) {
        this.timeSend = timeSend;
    }

    public Long getTimeAck() {
        return timeAck;
    }

    public void setTimeAck(Long timeAck) {
        this.timeAck = timeAck;
    }

    public Long getTimeCpl() {
        return timeCpl;
    }

    public void setTimeCpl(Long timeCpl) {
        this.timeCpl = timeCpl;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DeviceCommandDTO{" +
                "cmdId='" + cmdId + '\'' +
                ", deviceKey='" + deviceKey + '\'' +
                ", timeReq=" + timeReq +
                ", timeDue=" + timeDue +
                ", timeSend=" + timeSend +
                ", timeAck=" + timeAck +
                ", timeCpl=" + timeCpl +
                ", state=" + state +
                ", type=" + type +
                ", data=" + data +
                '}';
    }
}
