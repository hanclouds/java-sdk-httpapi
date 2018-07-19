package com.hanclouds.enums;

/**
 * 瀚云云平台传感器设备上传的数据类型
 *
 * @author szl
 * @date 2018/3/30
 */
public enum DataTypeEnum {
    /**
     * 无效数据类型
     */
    INVALID(0),
    /**
     * JSON类型
     */
    JSON(1),
    /**
     * 整数类型，4字节
     */
    INT(2),
    /**
     * 字符串类型
     */
    STRING(3),
    /**
     * 8字节浮点数
     */
    DOUBLE(4),
    /**
     * 二进制字节流
     */
    BIN(5);

    private final int value;

    DataTypeEnum(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public String stringValue() {
        switch (value) {
            case 1: {
                return "json";
            }
            case 2: {
                return "int";
            }
            case 3: {
                return "string";
            }
            case 4: {
                return "double";
            }
            case 5: {
                return "bin";
            }
            default: {
                return "invalid";
            }
        }
    }

   public static DataTypeEnum getDataTypeEnumByValue (int value) {
        for (DataTypeEnum type : DataTypeEnum.values()) {
             if (type.intValue() == value) {
                return type;
             }
        }
        return INVALID;
   }

    public static boolean contains(int type) {
        for (DataTypeEnum hyDataTypeEnum : DataTypeEnum.values()) {
            if (!hyDataTypeEnum.equals(INVALID) && hyDataTypeEnum.intValue() == type) {
                return true;
            }
        }
        return false;
    }

}
