package com.hanclouds.model;

import lombok.Data;

/**
 * @author majiwei
 * @date 2019/10/28
 */
@Data
public class ArchiveTemplateUpdateDTO extends ArchiveTemplateAddDTO
{
    /** 档案模板名称 */
    private Integer templateId;
}
