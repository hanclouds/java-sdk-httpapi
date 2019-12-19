package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.ArchiveTemplateParameter;
import com.hanclouds.model.ArchiveTemplateUpdateDTO;
import com.hanclouds.resp.ArchiveTemplateSaveResponse;
import com.hanclouds.util.ValidateUtils;

import java.util.List;

/**
 * 更新档案模板接口请求
 * @author mjw
 * @date 2019/10/21
 */
public class ArchiveTemplateUpdateRequest extends AbstractHttpRequest<ArchiveTemplateSaveResponse>
{

    private ArchiveTemplateUpdateDTO archiveTemplateUpdateDTO;

    public ArchiveTemplateUpdateDTO getArchiveTemplateUpdateDTO()
    {
        return archiveTemplateUpdateDTO;
    }

    public void setArchiveTemplateUpdateDTO(ArchiveTemplateUpdateDTO archiveTemplateUpdateDTO)
    {
        this.archiveTemplateUpdateDTO = archiveTemplateUpdateDTO;
    }

    public ArchiveTemplateUpdateRequest() {
        super("/archives/template/{templateId}");
        this.setHttpMethod(HttpMethodEnum.PUT);
    }

    @Override
    public Class<ArchiveTemplateSaveResponse> getResponseClass() {
        return ArchiveTemplateSaveResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        Integer templateId = archiveTemplateUpdateDTO.getTemplateId();
        if(templateId == null || templateId <= 0){
            throw new HanCloudsClientException("the templateId can not be null or less than zero");
        }

        List<ArchiveTemplateParameter> parameters = archiveTemplateUpdateDTO.getParameters();
        ValidateUtils.validateArchiveTempalte(archiveTemplateUpdateDTO, parameters);

        this.setUrl(this.getUrl().replace("{templateId}", String.valueOf(templateId)));
        this.setBodyContentByObject(archiveTemplateUpdateDTO);
    }
}
