package com.hanclouds.model;

import lombok.Data;

/**
 * 档案模板信息
 * @author majiwei
 * @date 2019/10/24
 */
@Data
public class ArchiveTemplateDTO
{
    /** 创建时间 */
    private Long createTime;
    /** 用户key */
    private String userKey;
    /** 项目key */
    private String projectKey;
    /** 模板ID */
    private Integer templateId;
    /** 模板名称 */
    private String templateName;
    /** 模板描述 */
    private String desc;
    /** 模板jsonSchema */
    private String jsonSchema;
}
