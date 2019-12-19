package com.hanclouds.req;

import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DataStreamTemplatePageResponse;
import com.hanclouds.util.StringUtils;

/**
 * 分页查询数据流模板
 * @author majiwei
 * @date 2019/11/13
 */
public class DataStreamTemplatePageRequest
    extends AbstractProductKeyPageRequest<DataStreamTemplatePageResponse>
{
    /** 数据流模板标识,左匹配模糊查询 */
    private String identifier;

    /** 数据流模板类型 */
    private DataTypeEnum dataType;

    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
        if(StringUtils.isNotBlank(identifier)){
            this.putQueryParameter("identifier", identifier);
        }
    }

    public DataTypeEnum getDataType()
    {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType)
    {
        this.dataType = dataType;
        if(dataType != null){
            this.putQueryParameter("dataType", String.valueOf(dataType.intValue()));
        }
    }

    public DataStreamTemplatePageRequest() {
        super("/dataStream/template/{productKey}/page");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DataStreamTemplatePageResponse> getResponseClass() {
      return DataStreamTemplatePageResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException
    {
      super.validate();

      if (page != null && this.page <= 0) {
        throw new HanCloudsClientException("page must greater than zero");
      }
      if (pageSize != null && this.pageSize <= 0) {
        throw new HanCloudsClientException("pageSize must greater than zero");
      }
    }
}
