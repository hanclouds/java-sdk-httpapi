package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.ArchiveAddDTO;
import com.hanclouds.resp.ArchiveAddBatchResponse;
import com.hanclouds.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 设备档案批量接口请求
 * @author mjw
 * @date 2019/10/21
 */
public class ArchiveAddBatchRequest extends AbstractHttpRequest<ArchiveAddBatchResponse>
{

    private List<ArchiveAddDTO> archiveRecordAddDTOList;

    public List<ArchiveAddDTO> getArchiveRecordAddDTOList()
    {
        return archiveRecordAddDTOList;
    }

    public void setArchiveRecordAddDTOList(List<ArchiveAddDTO> archiveRecordAddDTOList)
    {
        this.archiveRecordAddDTOList = archiveRecordAddDTOList;
    }

    public ArchiveAddBatchRequest() {
        super("/archives/batch");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<ArchiveAddBatchResponse> getResponseClass() {
        return ArchiveAddBatchResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        for(ArchiveAddDTO archiveRecordAddDTO : archiveRecordAddDTOList){
            String deviceKey = archiveRecordAddDTO.getDeviceKey();
            Integer templateId = archiveRecordAddDTO.getTemplateId();
            Map<String, Object> propertyData = archiveRecordAddDTO.getPropertyData();

            if(StringUtils.isEmpty(deviceKey)){
                throw new HanCloudsClientException("deviceKey can not null or empty");
            }
            if (templateId == null || templateId < 0) {
                throw new HanCloudsClientException("templateId can not null or less than zero");
            }
            if (propertyData == null || propertyData.size() <= 0) {
                throw new HanCloudsClientException("propertyData can not null or empty");
            }
        }

        this.setBodyContentByObject(this.archiveRecordAddDTOList);
    }
}
