package com.hanclouds.enums;

/**
 * 卡状态
 */
public enum CardStatusEnum {

    /**
     * 可测试
     */
    CAN_TEST("CAN_TEST", "可测试"),
    /**
     * 已激活
     */
    CAN_ACTIVATION("CAN_ACTIVATION", "已激活"),
    /**
     * 到期
     */
    EXPIRE("EXPIRE", "到期"),
    /**
     * 停机
     */
    STOP_SERVICE("STOP_SERVICE", "停机"),
    /**
     * 销号
     */
    CANCEL_NUM("CANCEL_NUM", "已销户"),
    /**
     * 待激活
     */
    WAIT_ACTIVATION("WAIT_ACTIVATION", "待激活"),

    /**
     * 库存
     */
    CARD_LEAVE("CARD_LEAVE", "库存"),

    /**
     * 预销户
     */
    CAN_CANCEL_NUM("CAN_CANCEL_NUM", "预销户"),
    ;

    private String code;

    private String message;

    CardStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByCode(String code) {
        CardStatusEnum[] values = CardStatusEnum.values();
        for (CardStatusEnum value : values) {
            if (value.code.equalsIgnoreCase(code)) {
                return value.message;
            }
        }
        return null;
    }
    public static String getIntByMessage(String msg) {
        String retMessage = CAN_TEST.message;
        switch (msg) {
            case "待激活":
                retMessage = "1";
                break;
            case "已激活":
                retMessage = "2";
                break;
            case "停机":
                retMessage ="4";
                break;
            case "可测试":
                retMessage ="6";
                break;
            case "库存":
                retMessage ="7";
                break;
            case "预销户":
                retMessage ="8";
                break;
            default:
                break;

        }
        return retMessage;
    }

    public static String getCodeByMessage(String message) {
        CardStatusEnum[] values = CardStatusEnum.values();
        for (CardStatusEnum value : values) {
            if (value.message.equalsIgnoreCase(message)) {
                return value.code;
            }
        }
        return null;
    }
}
