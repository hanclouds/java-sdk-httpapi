package com.hanclouds.util;

import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.model.ArchiveTemplateAddDTO;
import com.hanclouds.model.ArchiveTemplateParameter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author majiwei
 * @date 2019/10/28
 */
public class ValidateUtils
{
    /**
     * 模板名称的长度限制
     */
    private static final Integer MAX_TEMPLATE_NAME_LIMIT = 20;

    /**
     * 模板描述的长度限制
     */
    private static final Integer MAX_TEMPLATE_DESC_LIMIT = 100;

    /**
     * 分页查询page*pageSize总数限制
     */
    private static final Integer QUERY_NUM_LIMIT = 100000;

    public static void validateArchiveTempalte(ArchiveTemplateAddDTO archiveTemplateAddDTO, List<ArchiveTemplateParameter> parameters) throws HanCloudsClientException
    {
        if(archiveTemplateAddDTO == null){
            throw new HanCloudsClientException("the template info can not be null");
        }

        String templateName = archiveTemplateAddDTO.getName();
        String desc = archiveTemplateAddDTO.getDesc();
        if(StringUtils.isBlank(templateName)){
            throw new HanCloudsClientException("the template name can not be null or empty");
        }

        if(templateName.length() > MAX_TEMPLATE_NAME_LIMIT){
            throw new HanCloudsClientException("template name cannot be longer than 20");
        }

        if(StringUtils.isNotEmpty(desc) && desc.length() > MAX_TEMPLATE_DESC_LIMIT){
            throw new HanCloudsClientException("template desc cannot be longer than 100");
        }


        if(parameters == null || parameters.isEmpty()){
            throw new HanCloudsClientException("the parameters field can not be null or empty");
        }

        //收集属性名称
        Set<String> fieldNameSet = new HashSet();
        //收集标识符
        Set<String> identifierSet = new HashSet();
        for (ArchiveTemplateParameter parameter : parameters) {

            String name = parameter.getName();
            String identifier = parameter.getIdentifier();

            //属性名称检查
            if (StringUtils.isBlank(name)) {
                throw new HanCloudsClientException(String.format("参数[%s]的属性名称不能为空", name));
            }

            // 名称格式检查
            if(!SdkRegexUtils.chechArchiveTemplateProperyName(name)){
                throw new HanCloudsClientException(String.format("参数[%s]的名称格式错误，支持大小写字母、数字、下划线、短划线、小数点，必须以中文、英文或数字开头，不超过30个字符", name));
            }

            //标识符检查
            if (StringUtils.isBlank(identifier)) {
                throw new HanCloudsClientException(String.format("参数[%s]的标识符不能为空", name));
            }

            //标识符格式检查
            if(!checkIdentifierFormat(identifier)){
                throw new HanCloudsClientException(String.format("参数[%s]的标识符格式错误，支持大小写字母、数字、下划线，不超过50个字符", name));
            }

            //数据类型检查
            if (null == parameter.getDataType()) {
                throw new HanCloudsClientException(String.format("参数[%s]的数据类型不能为空", name));
            }

            fieldNameSet.add(name);
            identifierSet.add(identifier);
            //检查map参数合法性
            checkMapData(parameter);
        }
        //属性名称重复检查
        if (fieldNameSet.size() < parameters.size()) {
            throw new HanCloudsClientException("档案参数的属性名称不能重复");
        }
        //标识符重复检查
        if (identifierSet.size() < parameters.size()) {
            throw new HanCloudsClientException("档案参数的标识符不能重复");
        }
    }

    /**
     * 检查标识符格式
     * @param identifier
     * @return
     */
    private static boolean checkIdentifierFormat(String identifier){
        //数字字母下划线,最大长度为50
        String regex = "[0-9A-Za-z_]{1,50}";
        Matcher matcher = Pattern.compile(regex).matcher(identifier);
        return matcher.matches();
    }

    private static void checkMapData(ArchiveTemplateParameter parameter) throws HanCloudsClientException
    {
        //获取map参数
        DataTypeEnum fieldType = parameter.getDataType();
        String fieldName = parameter.getName();
        Map<String, String> map = parameter.getMap();
        switch (fieldType) {
            case STRING:
                //字符型 默认长度为2048
                if (null == map || map.isEmpty() || StringUtils.isBlank(map.get("max"))) {
                    map = new HashMap();
                    map.put("max", String.valueOf(2048));
                    parameter.setMap(map);
                }
                break;
            case INTEGER:
                int maxInt = 0;
                if (!StringUtils.isBlank(map.get("max"))) {
                    try {
                        maxInt = Integer.parseInt(map.get("max"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Integer.MIN_VALUE,Integer.MAX_VALUE,fieldName));
                    }
                }

                int minInt = 0;
                if (!StringUtils.isBlank(map.get("min"))) {
                    try {
                        minInt = Integer.parseInt(map.get("min"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Integer.MIN_VALUE,Integer.MAX_VALUE,fieldName));
                    }

                    if(!StringUtils.isBlank(map.get("max")) && minInt > maxInt){
                        throw new HanCloudsClientException(String.format("参数[%s]的最小值不能大于最大值", fieldName));
                    }
                }

                int stepInt;
                if (!StringUtils.isBlank(map.get("step"))) {
                    try {
                        stepInt = Integer.parseInt(map.get("step"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Integer.MIN_VALUE,Integer.MAX_VALUE,fieldName));
                    }

                    if (stepInt <= 0) {
                        throw new HanCloudsClientException(String.format("数据步长必须大于0, 属性名称=%s", fieldName));
                    }

                    if (stepInt < minInt || stepInt > maxInt) {
                        throw new HanCloudsClientException(String.format("数据步长必须在取值范围内, 属性名称=%s", fieldName));
                    }
                }


                break;
            case FLOAT:
                float maxFloat = 0;
                if (!StringUtils.isBlank(map.get("max"))) {
                    try {
                        maxFloat = Float.parseFloat(map.get("max"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Float.MIN_VALUE, Float.MAX_VALUE, fieldName));
                    }
                }

                float minFloat = 0;
                if (!StringUtils.isBlank(map.get("min"))) {
                    try {
                        minFloat = Float.parseFloat(map.get("min"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Float.MIN_VALUE, Float.MAX_VALUE, fieldName));
                    }

                    if(!StringUtils.isBlank(map.get("max")) && minFloat > maxFloat){
                        throw new HanCloudsClientException(String.format("参数[%s]的最小值不能大于最大值", fieldName));
                    }
                }

                float stepFloat;
                if (!StringUtils.isBlank(map.get("step"))) {
                    try {
                        stepFloat = Float.parseFloat(map.get("min"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Float.MIN_VALUE, Float.MAX_VALUE, fieldName));
                    }

                    if (stepFloat <= 0) {
                        throw new HanCloudsClientException(String.format("数据步长必须大于0, 属性名称=%s",fieldName));
                    }

                    if (stepFloat < minFloat || stepFloat > maxFloat) {
                        throw new HanCloudsClientException(String.format("数据步长必须在取值范围内, 属性名称=%s",fieldName));
                    }

                }
                break;
            case DOUBLE:
                double maxDouble = 0;
                if (!StringUtils.isBlank(map.get("max"))) {
                    try {
                        maxDouble = Double.parseDouble(map.get("max"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Double.MIN_VALUE, Double.MAX_VALUE, fieldName));
                    }
                }

                double minDouble = 0;
                if (!StringUtils.isBlank(map.get("min"))) {
                    try {
                        minDouble = Double.parseDouble(map.get("min"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Double.MIN_VALUE, Double.MAX_VALUE, fieldName));
                    }
                    if(!StringUtils.isBlank(map.get("max")) && minDouble > maxDouble){
                        throw new HanCloudsClientException(String.format("参数[%s]的最小值不能大于最大值", fieldName));
                    }
                }

                double stepDouble;
                if (!StringUtils.isBlank(map.get("step"))) {
                    try {
                        stepDouble = Double.parseDouble(map.get("min"));
                    } catch (NumberFormatException maxEx) {
                        throw new HanCloudsClientException(String.format("取值范围或步长必须为%s~%s之间的数字, 属性名称=%s",
                                Double.MIN_VALUE, Double.MAX_VALUE, fieldName));
                    }

                    if (stepDouble <= 0) {
                        throw new HanCloudsClientException(String.format("数据步长必须大于0, 属性名称=%s", fieldName));
                    }

                    if (stepDouble < minDouble || stepDouble > maxDouble) {
                        throw new HanCloudsClientException(String.format("数据步长必须在取值范围内, 属性名称=%s", fieldName));
                    }

                }
                break;
            default:
                throw new HanCloudsClientException(String.format("参数[%s]的数据类型必须为INTEGER、FLOAT、DOUBLE或者STRING类型", fieldName));
        }
    }

    /**
     * 分页参数校验
     * @param page
     * @param pageSize
     * @throws HanCloudsClientException
     */
    public static void validatePage(Integer page, Integer pageSize) throws HanCloudsClientException
    {
        if (page != null && page <= 0) {
            throw new HanCloudsClientException("page must greater than zero");
        }

        if (pageSize != null && pageSize <= 0) {
            throw new HanCloudsClientException("pageSize must greater than zero");
        }

        if (page != null && pageSize != null && page * pageSize > QUERY_NUM_LIMIT) {
            throw new HanCloudsClientException("page乘以pageSize的值不能大于10万");
        }
    }
}
