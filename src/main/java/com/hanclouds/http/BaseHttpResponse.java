package com.hanclouds.http;

import com.alibaba.fastjson.JSON;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class BaseHttpResponse {

    protected byte[] bodyContent;

    protected Integer httpCode;

    protected ErrorMessage errorMessage;


    public Integer getHttpCode() {
        return httpCode;
    }

    public boolean isSuccess() {
        if (this.httpCode == null || this.httpCode != HttpURLConnection.HTTP_OK) {
            return false;
        }

        return true;
    }

    public byte[] getBodyContent() {
        return bodyContent;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    /**
     * 从打开的httpConnection里边返回一个Response
     *
     * @param httpURLConnection
     * @return
     */
    public static BaseHttpResponse getResponse(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        Integer httpCode = httpURLConnection.getResponseCode();
        if (httpCode == HttpURLConnection.HTTP_OK) {
            inputStream = httpURLConnection.getInputStream();
        } else {
            inputStream = httpURLConnection.getErrorStream();
        }

        BaseHttpResponse response = new BaseHttpResponse();
        response.httpCode = httpCode;

        if (inputStream != null) {
            //读取内容
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] contentBuf = new byte[1024];

            while (true) {
                final int read = inputStream.read(contentBuf);
                if (read == -1) {
                    break;
                }
                outputStream.write(contentBuf, 0, read);
            }

            byte[] content = outputStream.toByteArray();

            //检查是否是error信息，是的话直接解析保存
            if (!response.isSuccess()) {
                ErrorMessage errorMessage = dataToErrorMessage(content);
                response.errorMessage = errorMessage;
            } else {
                if (content != null) {
                    response.bodyContent = content;
                }
            }
        }

        return response;
    }

    /**
     * 将数据从json结构转为 ErrorMessage
     *
     * @param data
     * @return
     */
    private static ErrorMessage dataToErrorMessage(byte[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        ErrorMessage errorMessage = JSON.parseObject(data, ErrorMessage.class);
        return errorMessage;
    }
}
