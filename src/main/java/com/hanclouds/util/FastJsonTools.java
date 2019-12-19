package com.hanclouds.util;

import java.util.List;

import com.alibaba.fastjson.*;
import com.hanclouds.model.PageResponse;

/**
 * @author czl
 * @version 1.0
 * @date 2018/5/11 15:35
 */
public class FastJsonTools {

    public static <T> PageResponse<T> getPage(String jsonString, Class<T> clz) {
        try {
            PageResponse<T> page = JSON.parseObject(jsonString, new TypeReference<PageResponse<T>>() {});
            List<T> list = JSONArray.parseArray(JSON.toJSONString(page.getData()), clz);
            page.setData(list);
            return page;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 判断字符串是否是合法的JSON字符串
     *
     * @param str
     * @return
     */
    public static boolean isJsonStrValid(String str) {
        try {
            JSONObject.parseObject(str);
        } catch (Exception e) {
            try {
                JSONObject.parseArray(str);
            } catch (JSONException e1) {
                return false;
            }
        }

        return true;
    }
}
