package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DataPushResponse;
import com.hanclouds.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 为应用侧创建一次性的密钥（用于订阅MQTT Topic）
 * MQTT Topic数组，目前支持的topic有三种：data（数据）、cmd（命令）、event（事件），" +
 * "单个topic的格式为：data/{productKey}/{deviceKey}/#，最多100个
 *
 * @author czl
 * @version 1.0
 * @date 2018/4/28 23:06
 */
public class DataPushRequest extends AbstractHttpRequest<DataPushResponse> {

    private String productKey;

    private List<String> topics;

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public DataPushRequest() {
        super("/pushsvcs/createAuthToken");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<DataPushResponse> getResponseClass() {
        return DataPushResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        if (topics == null || topics.size() <= 0) {
            throw new HanCloudsClientException("topics list size must greater than zero");
        }
        if (StringUtils.isBlank(productKey)) {
            throw new HanCloudsClientException("productKey can not null or empty");
        }
        Map<String, Object> req = new HashMap<String, Object>(2);
        req.put("topics", this.topics);
        req.put("productKey", this.productKey);
        setBodyContentByObject(req);
    }

}
