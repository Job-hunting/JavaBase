/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.louis.tools.exception;

/**
 * 错误码种类
 */
public enum ErrorCode implements ExceptionType {
    SUCCESS("成功", 0),
    BAD_PARAM("非法参数", 10),
    INVALID_USER("非法用户", 11),
    SIGN_CHECK_FAIL("签名失败，校验失败", 12),
    SIGN_CHECK_EXPIRE("签名失败，签名过期", 13),
    SIGN_CHECK_BAD_PARAM("签名失败，非法参数", 14),
    BUSINESS_EXCEPTION("业务异常", 30),
    SYSTEM_EXCEPTION("系统异常", 50),
    SYSTEM_BUSY("系统繁忙", 51),
    FAIL("失败", 99);

    private String desc;
    private Integer code;

    ErrorCode(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public static ErrorCode getByCode(Integer code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getCode().compareTo(code) == 0) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("unknown code:" + code);
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
