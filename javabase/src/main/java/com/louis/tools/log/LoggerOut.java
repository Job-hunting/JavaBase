package com.louis.tools.log;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.log;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * Marks a method as to be handled by {@link LoggerInterceptor}
// *
// * @see LoggerInterceptor
// * @see LoggerFormat
// */
//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.METHOD})
//@Documented
//public @interface LoggerOut {
//
//    /**
//     * Declares whether the log mode is debug.
//     * <p>Defaults to {@code false}.
//     */
//    boolean debug() default false;
//
//    /**
//     * Declares the log format
//     * <p>Defaults to {@code LoggerFormat.JSON}.
//     */
//    LoggerFormat format() default LoggerFormat.JSON;
//
//    /**
//     * Declares whether just print the log request body.
//     * <p>Defaults to {@code false}.
//     */
//    boolean onlyReq() default false;
//
//    /**
//     * Declares whether just print the log response body.
//     * <p>Defaults to {@code false}.
//     */
//    boolean onlyResp() default false;
//
//}
