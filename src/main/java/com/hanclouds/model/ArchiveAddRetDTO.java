package com.hanclouds.model;

import lombok.Data;

/**
 * 批量添加档案返回结构
 * @author majiwei
 * @date 2019/10/22
 */
@Data
public class ArchiveAddRetDTO
{
    private String deviceKey;
    private Integer templateId;
    private String archiveId;
}
