package com.hanclouds.model;

import lombok.Data;

import java.util.List;

/**
 * @author majiwei
 * @date 2019/10/28
 */
@Data
public class ArchiveTemplateAddDTO
{
    /** 档案模板名称 */
    private String name;
    /** 描述 */
    private String desc;
    /** 具体的参数 */
    private List<ArchiveTemplateParameter> parameters;
}
