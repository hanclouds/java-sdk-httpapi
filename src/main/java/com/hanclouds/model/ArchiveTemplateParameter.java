package com.hanclouds.model;

import com.hanclouds.enums.DataTypeEnum;
import lombok.Data;

import java.util.Map;

/**
 * @author huangchen
 * @date 2019/6/22
 */
@Data
public class ArchiveTemplateParameter
{

    /**
     * 参数名称
     */
    private String name;

    /**
     * 参数标识符
     */
    private String identifier;

    /**
     * 数据类型
     */
    private DataTypeEnum dataType;

    /**
     * 可变参数
     */
    private Map<String, String> map ;
}
