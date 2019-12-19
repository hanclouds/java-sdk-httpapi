package com.hanclouds.enums;

/**
 * 告警事件枚举
 *
 * @author majiwei
 * @date 2019/7/29
 */
public enum EventTypeEnum
{
  /** 信息 */
  info(1),
  /** 告警 */
  alert(2),
  /** 错误 */
  error(3);

  private final int value;

  EventTypeEnum(int value) {
    this.value = value;
  }

  public int intValue() {
    return value;
  }

  public static boolean contains(int type) {
    for (EventTypeEnum eventTypeEnum : EventTypeEnum.values()) {
      if (eventTypeEnum.intValue() == type) {
        return true;
      }
    }
    return false;
  }
}
