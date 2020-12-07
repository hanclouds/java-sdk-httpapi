package com.hanclouds.util;

import com.alibaba.fastjson.JSON;
import com.hanclouds.enums.DataTypeEnum;
import com.hanclouds.exception.HanCloudsClientException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author czl
 * @date 2018/04/10
 */
public class SdkRegexUtils
{

    private static Pattern emailRegex = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$", Pattern.CASE_INSENSITIVE);
    private static Pattern chineseMobileRegex = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[0-9]|19[0-9])[0-9]{8}$", Pattern.CASE_INSENSITIVE);
    private static Pattern dbMobileRegex = Pattern.compile("^(86-)(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[0-9]|19[0-9])[0-9]{8}$", Pattern.CASE_INSENSITIVE);
    private static Pattern usernameRegex = Pattern.compile("^[a-zA-Z0-9_!@#$%^&*().]{6,20}$", Pattern.CASE_INSENSITIVE);
    private static Pattern passwordRegex = Pattern.compile("(?!.*[\\u4E00-\\u9FA5\\s])(?!^[a-zA-Z]+$)(?!^[\\d]+$)(?!^[^a-zA-Z\\d]+$)^.{6,20}$", Pattern.CASE_INSENSITIVE);
    private static Pattern ipRegex = Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", Pattern.CASE_INSENSITIVE);
    private static Pattern base64Regex = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$", Pattern.CASE_INSENSITIVE);
    private static Pattern nameRegex = Pattern.compile("^[A-Za-z0-9_!@#$%^&*()\\u4e00-\\u9fa5]+$", Pattern.CASE_INSENSITIVE);
    private static Pattern deviceNameRegex = Pattern.compile("^[-A-Za-z0-9_!@#$%^&*()\\u4e00-\\u9fa5]+$", Pattern.CASE_INSENSITIVE);
    private static Pattern archiveTemplateProperyNameRegex = Pattern.compile("^(?![-._])[-A-Za-z0-9_.\\u4e00-\\u9fa5]{1,30}$", Pattern.CASE_INSENSITIVE);

    private static final int MOBILE_LENGTH = 11;
    private static final int MAX_ADDRESS_LENGTH = 15;
    private static final int MIN_ADDRESS_LENGTH = 7;

    /**
     * 判断是否是邮箱
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = emailRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断中国手机号码
     * @param str
     * @return
     */
    public static boolean isChineseMobile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = chineseMobileRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static String toDBMobile(String mobile) {
        if (mobile.length() == MOBILE_LENGTH) {
            return "86-" + mobile;
        } else if (mobile.length() > MOBILE_LENGTH){
            return "86-" + mobile.substring(mobile.length() - 11);
        }
        else {
            return mobile;
        }
    }

    /**
     * 数据库最终存的手机号码
     * @param str
     * @return
     */
    public static boolean isDbMobile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = dbMobileRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断用户名规则是否合法
     * @param str
     * @return
     */
    public static boolean checkUsername(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = usernameRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断密码规则是否合法，字母、数字、特殊字符最少2种组合（不能有中文和空格）
     * @param str
     * @return
     */
    public static boolean checkPassword(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = passwordRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断ip格式是否正确
     * @param addr
     * @return
     */
    public static boolean isIP(String addr) {
        if ("".equals(addr) || addr.length() < MIN_ADDRESS_LENGTH || addr.length() > MAX_ADDRESS_LENGTH) {
            return false;
        }
        Matcher matcher = ipRegex.matcher(addr);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否是base64编码
     * @param str
     * @return
     */
    public static boolean isBase64(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = base64Regex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断通用名称规则是否合法，字母、数字、特殊字符、中文
     * @param str
     * @return
     */
    public static boolean checkName(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = nameRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 判断通用名称规则是否合法，字母、数字、特殊字符、中文、短横线
     * @param str
     * @return
     */
    public static boolean checkDeviceName(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = deviceNameRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断档案模板属性名称规则是否合法，大小写字母、数字、下划线、短划线、小数点，必须以中文、英文或数字开头,长度不能超过30
     * @param str
     * @return
     */
    public static boolean chechArchiveTemplateProperyName(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Matcher matcher = archiveTemplateProperyNameRegex.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void dataFormat(DataTypeEnum dataType,String content) throws HanCloudsClientException {
        try {
            switch (dataType) {
                case JSON: {
                    try {
                        JSON.parseObject(content);
                    } catch (Exception e) {
                        throw new HanCloudsClientException("the data is not json format");
                    }
                }
                break;
                case INTEGER: {
                    Integer.parseInt(content);
                }
                break;
                case STRING: {
                    if(StringUtils.isBlank(content)) {
                        throw new HanCloudsClientException("the content can not null or empty");
                    }
                }
                break;
                case DOUBLE: {
                    Double.parseDouble(content);
                }
                break;
                case BIN: {
                    if(!SdkRegexUtils.isBase64(content)){
                        throw new HanCloudsClientException("the content must base64 string");
                    }
                }
                break;
                case BOOLEAN:
                    break;
                case ARRAY:
                    break;
                case ENUM:
                    break;
                case FLOAT:
                    break;
                case GPS:
                    break;
                case LONG:
                    break;
                case IMAGE:
                    break;
                case DATE:
                    break;
                default: {
                    throw new HanCloudsClientException("the dataType is invalid");
                }
            }
        } catch (NumberFormatException e) {
            throw new HanCloudsClientException("number format error");
        }
    }
}
