package com.hanclouds.model;

import lombok.Data;

/**
 * @author majiwei
 * @date 2019/11/13
 */
@Data
public class DataStreamTemplateDTO
{
    /**
     * 数据流id
     */
    private Integer id;

    /**
     * 数据流标识，用于匹配
     */
    private String identifier;

    /**
     * 数据流名称，用于展示
     */
    private String dataName;

    /**
     * 单位名称
     */
    private String dataUnit;

    /**
     * 单位符号
     */
    private String unitSymbol;

    /**
     * 数据类型
     */
    private Integer dataType;

    /**
     *数据流描述
     */
    private String desc;

    /**
     * 代码内容
     */
    private String jsonSchema;

    /**
     * 业务类型
     */
    private Integer bussinessType;

    /**
     * 是否是标准功能
     */
    private Boolean standard;
}
