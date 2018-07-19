package com.hanclouds.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.hanclouds.model.PageResponse;

import java.util.List;

/**
 * @author czl
 * @version 1.0
 * @date 2018/5/11 15:35
 */
public class FastJsonTools {

    public static <T> PageResponse<T> getPage(String jsonString, Class<T> clz) {
        try {
            PageResponse<T> page =  JSON.parseObject(jsonString,
                    new TypeReference<PageResponse<T>>() {
                    });
            List<T> list = JSONArray.parseArray(JSON.toJSONString(page.getData()), clz);
            page.setData(list);
            return page;
        } catch (Exception e) {
        }
        return null;
    }

}
