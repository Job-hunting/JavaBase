/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.louis.tools.exception;

/**
 * 定义业务异常类型 <br/>
 * {@link ErrorCode} 实现了一批基础异常类型，可以直接使用，或者自己实现
 */
public interface ExceptionType {

    /**
     * 业务异常编码
     * @return
     */
    Integer getCode();

    /**
     * 异常描述性文字
     * @return
     */
    String getDesc();
}
