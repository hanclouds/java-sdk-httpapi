package com.hanclouds.http;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class ErrorMessage {

    private String callId;

    private String code;

    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMessage(String code, String message, String callId) {
        this.code = code;
        this.message = message;
        this.callId = callId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }
}
