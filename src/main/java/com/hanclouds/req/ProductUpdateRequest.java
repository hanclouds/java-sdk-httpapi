package com.hanclouds.req;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.SdkRegexUtils;
import com.hanclouds.util.StringUtils;

/**
 * 产品更新请求
 * @author czl
 * @version 1.0
 * @date 2018/4/28 17:30
 */
public class ProductUpdateRequest extends AbstractProductKeyRequest<BooleanResponse> {

    private String productName;
    private String productIndustry;
    private String productCategory;
    private String descr;
    private String extendData;

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIndustry() {
        return this.productIndustry;
    }

    public void setProductIndustry(String productIndustry) {
        this.productIndustry = productIndustry;
    }

    public String getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getExtendData() {
        return this.extendData;
    }

    public void setExtendData(String extendData) {
        this.extendData = extendData;
    }

    public ProductUpdateRequest() {
        super("/products/{productKey}");
        this.setHttpMethod(HttpMethodEnum.PUT);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (productName!=null&&StringUtils.isBlank(productName)) {
            throw new HanCloudsClientException("productName can not null or empty");
        }
        if (productName!=null&&!SdkRegexUtils.checkName(productName)) {
            throw new HanCloudsClientException("productName format error");
        }
        if (productIndustry!=null&&StringUtils.isBlank(productIndustry)) {
            throw new HanCloudsClientException("productIndustry can not null or empty");
        }
        if (productCategory!=null&&StringUtils.isBlank(productCategory)) {
            throw new HanCloudsClientException("productCategory can not null or empty");
        }
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
                ProductUpdateRequest.class,
                "productName","productIndustry","productCategory","descr","extendData"
        );
        setBodyContentByObject(filter);
    }
}