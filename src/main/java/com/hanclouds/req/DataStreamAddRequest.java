package com.hanclouds.req;

import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.DataStreamAddDTO;
import com.hanclouds.resp.DataStreamAddResponse;
import com.hanclouds.util.StringUtils;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 14:09
 */
@Deprecated
public class DataStreamAddRequest extends AbstractProductKeyRequest<DataStreamAddResponse> {

    private DataStreamAddDTO dataStreamAddDTO;

    public DataStreamAddDTO getDataStreamAddDTO() {
        return dataStreamAddDTO;
    }

    public void setDataStreamAddDTO(DataStreamAddDTO dataStreamAddDTO) {
        this.dataStreamAddDTO = dataStreamAddDTO;
    }

    public DataStreamAddRequest() {
        super("/products/{productKey}/datastreams");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<DataStreamAddResponse> getResponseClass() {
        return DataStreamAddResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (StringUtils.isBlank(dataStreamAddDTO.getDataName())
                || dataStreamAddDTO.getDataType() == null) {
            throw new HanCloudsClientException("必填参数为空");
        }
        if (!DataTypeEnum.contains(dataStreamAddDTO.getDataType())) {
            throw new HanCloudsClientException("数据类型错误");
        }
        this.setBodyContentByObject(this.dataStreamAddDTO);
    }
}
