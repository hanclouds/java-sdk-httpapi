package com.hanclouds.model;

import lombok.Data;

import java.util.Map;

/**
 * 档案信息
 * @author majiwei
 * @date 2019/10/24
 */
@Data
public class ArchiveDTO
{
    /** 创建时间 */
    private long createTime;
    /** 更新时间 */
    private long updateTime;
    /** 项目key */
    private String projectKey;
    /** 产品key */
    private String productKey;
    /** 设备key */
    private String deviceKey;
    /** 档案ID */
    private String archiveId;
    /** 档案模板ID */
    private Integer templateId;
    /** 档案模板名称 */
    private String templateName;
    /** 档案属性数据 */
    private Map<String, Object> propertyData;
}
