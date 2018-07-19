package com.hanclouds.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class PageResponse<T> {
    private List<T> data;
    private int page;
    private int pageSize;
    private long total;

    public PageResponse() {
        this.data = new ArrayList<T>();
    }

    public PageResponse(List<T> data, int page, int pageSize, long total) {
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}