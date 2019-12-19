package com.hanclouds.model;

import lombok.Data;

/**
 * @author majiwei
 * @date 2019/10/28
 */
@Data
public class ArchiveTemplateSaveRetDTO
{
    /** 项目key */
    private String projectKey;
    /** 模板ID */
    private Integer templateId;
    /** 模板名称 */
    private String templateName;
}
