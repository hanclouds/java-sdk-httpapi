package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProjectKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.ArchiveTemplateAddDTO;
import com.hanclouds.model.ArchiveTemplateParameter;
import com.hanclouds.resp.ArchiveTemplateSaveResponse;
import com.hanclouds.util.ValidateUtils;

import java.util.List;

/**
 * 添加档案模板接口请求
 * @author mjw
 * @date 2019/10/21
 */
public class ArchiveTemplateAddRequest extends AbstractProjectKeyRequest<ArchiveTemplateSaveResponse>
{
    private ArchiveTemplateAddDTO archiveTemplateAddDTO;

    public ArchiveTemplateAddDTO getArchiveTemplateAddDTO()
    {
        return archiveTemplateAddDTO;
    }

    public void setArchiveTemplateAddDTO(ArchiveTemplateAddDTO archiveTemplateAddDTO)
    {
        this.archiveTemplateAddDTO = archiveTemplateAddDTO;
    }

    public ArchiveTemplateAddRequest() {
        super("/archives/template/{projectKey}");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<ArchiveTemplateSaveResponse> getResponseClass() {
        return ArchiveTemplateSaveResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        List<ArchiveTemplateParameter> parameters = archiveTemplateAddDTO.getParameters();
        ValidateUtils.validateArchiveTempalte(archiveTemplateAddDTO, parameters);

        this.setBodyContentByObject(archiveTemplateAddDTO);
    }
}
