package com.hanclouds.enums;

/**
 * Command status value
 *
 * @author szl
 * @date 2017/7/12
 */
public enum CommandStateEnum {
    /**
     * the command is saved but has not been send to the device
     */
    SAVED(1),
    /**
     * the command is send to the device and dons't receive the ack message
     */
    SENDED(2),
    /**
     * the command is send to the device and has receive the ack message
     */
    ACKED(3),
    /**
     * the command is send to the device, but don't receive the mqtt ack message before expire
     */
    EXPIRED(4),
    /**
     * the device publish cmdack/...  data
     */
    COMPLETE(5),
    /**
     * the command send to the device failed
     */
    FAILED(-1),
    /**
     * the command is canceled by the manager
     */
    CANCELED(-2);

    private final int value;

    CommandStateEnum(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
