package com.louis.tools.exception;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.exception;
//
///**
// * 功能描述:业务类异常<br/>
// * 系统中抛出的异常建议都继承此类，或直接使用此类
// */
//public class BusinessException extends RuntimeException {
//    private ExceptionType exceptionType;
//
//    public BusinessException(ExceptionType exceptionType) {
//        this(exceptionType, exceptionType.getDesc());
//    }
//
//    public BusinessException(ExceptionType exceptionType, String message) {
//        super(message);
//        this.exceptionType = exceptionType;
//    }
//
//    public BusinessException(ExceptionType exceptionType, String message, Throwable throwable) {
//        super(message, throwable);
//        this.exceptionType = exceptionType;
//    }
//
//    public ExceptionType getExceptionType() {
//        return exceptionType;
//    }
//}
