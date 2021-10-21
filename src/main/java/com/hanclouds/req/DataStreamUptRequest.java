package com.hanclouds.req;

import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyDataStreamRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.DataStreamUptDTO;
import com.hanclouds.resp.DataStreamUptResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 15:27
 */
@Deprecated
public class DataStreamUptRequest extends AbstractProductKeyDataStreamRequest<DataStreamUptResponse> {

    private DataStreamUptDTO uptDTO;

    public DataStreamUptDTO getUptDTO() {
        return uptDTO;
    }

    public void setUptDTO(DataStreamUptDTO uptDTO) {
        this.uptDTO = uptDTO;
    }

    public DataStreamUptRequest() {
        super("/products/{productKey}/datastreams/{dataName}");
        this.setHttpMethod(HttpMethodEnum.PUT);
    }


    @Override
    public Class<DataStreamUptResponse> getResponseClass() {
        return DataStreamUptResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (uptDTO.getDataType() != null && !DataTypeEnum.contains(uptDTO.getDataType())) {
            throw new HanCloudsClientException("数据类型错误");
        }
        this.setBodyContentByObject(this.uptDTO);
    }
}
