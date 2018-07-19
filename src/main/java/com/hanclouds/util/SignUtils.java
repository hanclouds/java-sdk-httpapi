package com.hanclouds.util;

import com.hanclouds.exception.HanCloudsClientException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class SignUtils {
    private final static String HMAC_SHA1 = "HmacSHA1";
    private final static String CHARSET_UTF8 = "utf-8";

    private final static char[] CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    public static String randomNonce(int len) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            buffer.append(CHARS[random.nextInt(62)]);
        }

        return buffer.toString();
    }


    public static String signWithHmacsh1(String secret, String content) throws HanCloudsClientException{
        try {
            byte[] keyBytes = secret.getBytes(CHARSET_UTF8);
            SecretKey secretKey = new SecretKeySpec(keyBytes, HMAC_SHA1);
            Mac mac = Mac.getInstance(HMAC_SHA1);
            mac.init(secretKey);
            byte[] rawHmac = mac.doFinal(content.getBytes(CHARSET_UTF8));
            return MigBase64.encodeToString(rawHmac, false);
        } catch (Exception e) {
            throw new HanCloudsClientException("sign error");
        }
    }
}
