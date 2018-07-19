package com.hanclouds.http;

import com.hanclouds.exception.HanCloudsClientException;

/**
 * @author zhangzhan
 * @version 1.0
 * @date 2018/6/25 10:20
 */
public abstract class AbstractProductKeyDataStreamRequest<T extends AbstractHttpResponse> extends AbstractProductKeyRequest<T> {
    protected String dataName;

    public AbstractProductKeyDataStreamRequest(String url) {
        super(url);
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    @Override
    public void validate()  throws HanCloudsClientException {
        super.validate();

        if (this.dataName == null || this.dataName.isEmpty()) {
            throw new HanCloudsClientException("dataName can not null or empty");
        }

        this.setUrl(this.getUrl().replace("{dataName}", this.dataName.toString()));
    }
}
