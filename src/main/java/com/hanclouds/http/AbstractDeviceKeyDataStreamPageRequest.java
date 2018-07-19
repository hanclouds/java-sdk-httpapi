package com.hanclouds.http;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.util.StringUtils;

/**
 * @author zhangzhan
 * @version 1.0
 * @date 2018/6/25 10:20
 */
public abstract class AbstractDeviceKeyDataStreamPageRequest<T extends AbstractHttpResponse> extends AbstractDeviceKeyPageRequest<T> {
    protected String dataName;

    public AbstractDeviceKeyDataStreamPageRequest(String url) {
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

        if (StringUtils.isBlank(this.dataName)) {
            throw new HanCloudsClientException("dataName can not null or empty");
        }

        this.setUrl(this.getUrl().replace("{dataName}", this.dataName));
    }
}
