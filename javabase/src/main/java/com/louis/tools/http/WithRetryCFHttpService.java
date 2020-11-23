package com.louis.tools.http;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.http;
//
//import org.asynchttpclient.AsyncHttpClientConfig;
//import org.asynchttpclient.DefaultAsyncHttpClient;
//import org.asynchttpclient.DefaultAsyncHttpClientConfig;
//import org.slf4j.LoggerFactory;
//
///**
// * 带重试的httpService 默认重试3次，重试间隔10ms
// */
//public class WithRetryCFHttpService extends AbstractCFHttpService {
//    private static final int DEFAULT_MAX_EXCEPTION_RETRY_TIMES = 3;
//    private static final int DEFAULT_RETRY_INTERVAL_MILLS = 10;
//    private Integer MAX_EXCEPTION_RETRY_TIMES;
//    private Integer RETRY_INTERVAL_MILLS;
//
//    public WithRetryCFHttpService(int defaultRequestTimeOut,
//                                  int maxExceptionRetryTimes, int retryIntervalMills) {
//        AsyncHttpClientConfig cf = new DefaultAsyncHttpClientConfig.Builder()
//                .setCompressionEnforced(true).setRequestTimeout(defaultRequestTimeOut)
//                .setConnectTimeout(defaultRequestTimeOut)
//                .setReadTimeout(defaultRequestTimeOut)
//                .setMaxRequestRetry(DEFAULT_RETRY_TIMES).build();
//        this.asyncHttpClient = new DefaultAsyncHttpClient(cf);
//
//        this.MAX_EXCEPTION_RETRY_TIMES = maxExceptionRetryTimes;
//        this.RETRY_INTERVAL_MILLS = retryIntervalMills;
//        logger = LoggerFactory.getLogger(WithRetryCFHttpService.class);
//    }
//
//    public WithRetryCFHttpService() {
//        this(DEFAULT_REQUEST_TIMEOUT, DEFAULT_MAX_EXCEPTION_RETRY_TIMES, DEFAULT_RETRY_INTERVAL_MILLS);
//    }
//
//    @Override
//    int getRetryTimes() {
//        return MAX_EXCEPTION_RETRY_TIMES;
//    }
//
//    @Override
//    int getRetryIntervalMills() {
//        return RETRY_INTERVAL_MILLS;
//    }
//
//}