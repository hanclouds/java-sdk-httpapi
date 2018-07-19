package com.hanclouds.http;

import java.net.HttpURLConnection;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public abstract class AbstractHttpResponse {
    protected BaseHttpResponse baseHttpResponse;

    protected Integer httpCode;

    protected ErrorMessage errorMessage;


    public BaseHttpResponse getBaseHttpResponse() {
        return baseHttpResponse;
    }

    public void setBaseHttpResponse(BaseHttpResponse baseHttpResponse) {
        this.baseHttpResponse = baseHttpResponse;
    }

    /**
     *解析对象
     */
    public abstract void parseBaseHttpResponse();


    public Integer getHttpCode() {
        if(baseHttpResponse!=null) {
            return baseHttpResponse.getHttpCode();
        }
        else {
            return 0;
        }
    }

    public ErrorMessage getErrorMessage() {
        if(baseHttpResponse!=null) {
            return baseHttpResponse.getErrorMessage();
        }
        else{
            return null;
        }
    }

    public Boolean isSucceed() {
        if (baseHttpResponse != null
                && baseHttpResponse.getHttpCode() == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            return false;
        }
    }
}
