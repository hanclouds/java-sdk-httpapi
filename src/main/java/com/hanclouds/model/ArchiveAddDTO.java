package com.hanclouds.model;

import lombok.Data;

import java.util.Map;

/**
 * @author mjw
 * @date 2019/10/21
 */
@Data
public class ArchiveAddDTO
{
    private String deviceKey;
    private Integer templateId;
    private Map<String, Object> propertyData;
}