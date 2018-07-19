package com.hanclouds.enums;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:21
 */
public enum ProtocolEnum {
    /**
     * http
     */
    HTTP(1),
    /**
     * mqtt
     */
    MQTT(2);

    private final int value;

    ProtocolEnum(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static boolean contains(int type) {
        for (ProtocolEnum typeEnum : ProtocolEnum.values()) {
            if (typeEnum.intValue() == type) {
                return true;
            }
        }
        return false;
    }

}
