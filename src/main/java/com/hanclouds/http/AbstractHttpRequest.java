package com.hanclouds.http;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.util.SignUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public abstract class AbstractHttpRequest<T extends AbstractHttpResponse> {
    private final static String PUT_POST_CONTENT_TYPE = "application/json";
    private final static String SIGNATURE = "signature";

    /**
     * 请求的url相对地址
     */
    private String url;

    protected HttpMethodEnum httpMethod;

    protected byte[] bodyContent;

    protected Map<String, String> headers;

    protected Map<String, String[]> queryParameters;

    protected Integer connectTimeout;

    protected Integer readTimeout;

    public AbstractHttpRequest(String url) {
        this.url = url;
        this.headers = new HashMap<String, String>();
        this.queryParameters = new HashMap<String, String[]>();
        this.httpMethod = HttpMethodEnum.GET;
        this.connectTimeout = 2000;
        this.readTimeout = 10000;
        this.putHeader("Connection", "close");
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Map<String, String[]> getQueryParameters() {
        return queryParameters;
    }

    public void putQueryParameter(String name, String value) {
        if (name == null || name.isEmpty()) {
            return;
        }

        if (value == null || value.isEmpty()) {
            this.queryParameters.remove(name);
        } else {
            String[] values = {value};
            this.queryParameters.put(name, values);
        }
    }

    public void putQueryParameter(String name, String[] values) {
        if (name == null || name.isEmpty()) {
            return;
        }

        if (values == null || values.length == 0) {
            this.queryParameters.remove(name);
        } else {
            this.queryParameters.put(name, values);
        }
    }

    public byte[] getBodyContent() {
        return this.bodyContent;
    }

    /**
     * 将data进行json序列化
     * 依赖fastjson android版本
     */
    public void setBodyContentByObject(SimplePropertyPreFilter filter) {
        setBodyContent(JSON.toJSONString(this,filter).getBytes(Charset.forName("UTF-8")));
    }

    /**
     * 将object进行json序列化
     * @param object
     */
    public void setBodyContentByObject(Object object) {
        if(object instanceof Number ||object instanceof Integer||object instanceof Float||
                object instanceof Double||object instanceof String||object instanceof Long
                ||object instanceof Long||object instanceof Byte){
            setBodyContent(object.toString().getBytes(Charset.forName("UTF-8")));
        }
        else {
            setBodyContent(JSON.toJSONString(object).getBytes(Charset.forName("UTF-8")));
        }
    }



    /**
     * 设置bodyContent默认添加 application/json 到 Content-Type
     * 如果为空，将从header中remove Content-Type
     * @param bodyContent
     */
    public void setBodyContent(byte[] bodyContent) {
        if (bodyContent == null) {
            this.headers.remove("Content-Type");
            this.headers.remove("Content-Length");
            this.bodyContent = null;
        }

        this.bodyContent = bodyContent;
        this.headers.put("Content-Type", PUT_POST_CONTENT_TYPE);
        this.headers.put("Content-Length", String.valueOf(bodyContent.length));
    }

    public String getUrl() {
        return url;
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    public HttpMethodEnum getHttpMethod() {
        return this.httpMethod;
    }

    public void setHttpMethod(HttpMethodEnum httpMethod) {
        if (httpMethod == null) {
            return;
        }

        if (httpMethod == HttpMethodEnum.POST || httpMethod == HttpMethodEnum.PUT) {
            this.headers.put("Content-Type", PUT_POST_CONTENT_TYPE);
        } else {
            this.headers.remove("Content-Type");
        }

        this.httpMethod = httpMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void putHeader(String name, String value) {
        if (name == null || name.isEmpty()) {
            return;
        }

        if (value == null || value.isEmpty()) {
            this.headers.remove(name);
        } else {
            this.headers.put(name, value);
        }
    }

    /**
     * 对整个request请求签名
     * 加入时间戳参数
     * 加入nonce参数
     * 加入signature参数
     */
    public boolean signAndPutQueryParams(String secretKey) throws HanCloudsClientException {
        if (secretKey == null || secretKey.isEmpty()) {
            return false;
        }

        long ts = System.currentTimeMillis();
        this.putQueryParameter("ts", String.valueOf(ts));

        String nonce = SignUtils.randomNonce(16);
        this.putQueryParameter("nonce", nonce);

        List<String> paramStrs = new ArrayList<String>(this.queryParameters.size());
        for (Map.Entry<String, String[]> entry : this.queryParameters.entrySet()) {
            if (entry.getValue().length == 0) {
                continue;
            }
            //签名参数不参与签名
            if (entry.getKey().equals(SIGNATURE)) {
                continue;
            }
            for (String v : entry.getValue()) {
                paramStrs.add(entry.getKey() + "=" + v);
            }
        }
        Collections.sort(paramStrs);
        StringBuilder signStrBuilder = new StringBuilder();
        boolean isFirstLoop = true;
        for (String paramStr : paramStrs) {
            if (isFirstLoop) {
                isFirstLoop = false;
            } else {
                signStrBuilder.append('&');
            }
            signStrBuilder.append(paramStr);
        }

        if (this.bodyContent != null && this.bodyContent.length > 0) {
            signStrBuilder.append(new String(this.bodyContent, Charset.forName("UTF-8")));
        }

        String signature = SignUtils.signWithHmacsh1(secretKey, signStrBuilder.toString());
        if (signature == null || signature.isEmpty()) {
            return false;
        }

        this.putQueryParameter("signature", signature);

        return true;
    }

    /**
     * 根据queryParameters构建url
     * @return
     */
    protected String getRequestUrl() throws HanCloudsClientException {
        if (this.url == null || this.url.isEmpty()) {
            return null;
        }

        String[] urlArr = this.url.split("\\?");
        this.url = urlArr[0];
        if (this.queryParameters.size() == 0) {
            return this.url;
        }

        StringBuilder urlQueryBuilder = new StringBuilder(this.url);
        urlQueryBuilder.append("?");
        for (Map.Entry<String, String[]> entry : this.queryParameters.entrySet()) {
            String name = entry.getKey();
            for (String value : entry.getValue()) {
                if (value == null || value.isEmpty()) {
                    continue;
                }
                try {
                    urlQueryBuilder.append(URLEncoder.encode(name, "UTF-8"));
                    urlQueryBuilder.append("=");
                    urlQueryBuilder.append(URLEncoder.encode(value, "UTF-8"));
                    urlQueryBuilder.append("&");
                } catch (UnsupportedEncodingException e) {
                    throw new HanCloudsClientException(e.getMessage());
                }
            }
        }
        return urlQueryBuilder.toString();
    }

    /**
     * 根据request信息返回一个httpConnection的对象
     * @param gatewayUrl gatewayUrl 包含http请求路径前缀，例如: http://127.0.0.1
     * @return
     */
    public HttpURLConnection getHttpConnection(String gatewayUrl) throws HanCloudsClientException {
        if (gatewayUrl == null || gatewayUrl.isEmpty()) {
            throw new HanCloudsClientException("gateway url is empty");
        }

        String urlStr = gatewayUrl + this.getRequestUrl();

        URL url = null;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            return null;
        }

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        //创建http链接
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new HanCloudsClientException(e.getMessage());
        }

        try {
            httpURLConnection.setRequestMethod(this.httpMethod.name());
        } catch (ProtocolException e) {
            throw new HanCloudsClientException(e.getMessage());
        }

        httpURLConnection.setUseCaches(false);
        if(!HttpMethodEnum.GET.equals(this.httpMethod)) {
            httpURLConnection.setDoOutput(true);
        }
        if (this.readTimeout != null) {
            httpURLConnection.setReadTimeout(this.readTimeout);
        }

        if (this.connectTimeout != null) {
            httpURLConnection.setConnectTimeout(this.connectTimeout);
        }

        if (this.headers.size() > 0) {
            //设置header
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        if (this.bodyContent != null && this.bodyContent.length > 0) {
            try {
                httpURLConnection.getOutputStream().write(this.bodyContent);
            } catch (IOException e) {

            }
        }

        return httpURLConnection;
    }

    /**
     * 得到返回对象
     * @return
     */
    public abstract Class<T> getResponseClass();

    /**
     * 验证参数
     * @throws HanCloudsClientException
     */
    public abstract void validate() throws HanCloudsClientException;
}
