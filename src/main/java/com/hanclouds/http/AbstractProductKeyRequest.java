package com.hanclouds.http;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.util.StringUtils;

/**
 * @author zhangzhan
 * @version 1.0
 * @date 2018/6/25 10:20
 */
public abstract class AbstractProductKeyRequest<T extends AbstractHttpResponse> extends AbstractHttpRequest<T> {

    protected String productKey;

    public AbstractProductKeyRequest(String url) {
        super(url);
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    @Override
    public void validate()  throws HanCloudsClientException {
        if (StringUtils.isBlank(this.productKey)) {
            throw new HanCloudsClientException("productKey can not null or empty");
        }

        this.setUrl(this.getUrl().replace("{productKey}", this.productKey));
    }
}
