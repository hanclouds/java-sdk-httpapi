package com.hanclouds.http;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public abstract class AbstractHttpPageRequest<T extends AbstractHttpResponse> extends AbstractHttpRequest<T> {
    protected String sort;
    protected String order;
    protected Integer page=1;
    protected Integer pageSize=100;

    public AbstractHttpPageRequest(String urlStr) {

        super(urlStr);
        this.putQueryParameter("page", page.toString());
        this.putQueryParameter("pageSize", pageSize.toString());
    }

    public String getSort() {
        return sort;
    }

    public String getOrder() {
        return order;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setSort(String sort) {
        this.sort = sort;
        this.putQueryParameter("sort", sort);
    }

    public void setOrder(String order) {
        this.order = order;
        this.putQueryParameter("order", order);
    }

    public void setPage(Integer page) {
        this.page = page;
        if (page != null) {
            this.putQueryParameter("page", page.toString());
        } else {
            this.putQueryParameter("page", "");
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (page != null) {
            this.putQueryParameter("pageSize", pageSize.toString());
        } else {
            this.putQueryParameter("pageSize", "");
        }
    }
}
