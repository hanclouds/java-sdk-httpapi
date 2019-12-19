package com.hanclouds.http;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.util.StringUtils;

/**
 * @author majiwei
 * @date 2019/10/24
 */
public abstract class AbstractProjectKeyPageRequest<T extends AbstractHttpResponse> extends AbstractHttpPageRequest<T> {
    protected String projectKey;

    public AbstractProjectKeyPageRequest(String url) {
        super(url);
    }

    public String getProjectKey()
    {
        return projectKey;
    }

    public void setProjectKey(String projectKey)
    {
        this.projectKey = projectKey;
    }

    @Override
    public void validate()  throws HanCloudsClientException {
        if (StringUtils.isBlank(this.projectKey)) {
            throw new HanCloudsClientException("projectKey can not null or empty");
        }

        this.setUrl(this.getUrl().replace("{projectKey}", this.projectKey));
    }
}
