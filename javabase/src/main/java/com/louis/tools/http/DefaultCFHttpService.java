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
//public class DefaultCFHttpService extends AbstractCFHttpService {
//
//    public DefaultCFHttpService(int defaultRequestTimeOut) {
//        AsyncHttpClientConfig cf = new DefaultAsyncHttpClientConfig.Builder()
//                .setCompressionEnforced(true).setRequestTimeout(defaultRequestTimeOut)
//                .setConnectTimeout(defaultRequestTimeOut)
//                .setReadTimeout(defaultRequestTimeOut)
//                .setMaxRequestRetry(DEFAULT_RETRY_TIMES).build();
//        this.asyncHttpClient = new DefaultAsyncHttpClient(cf);
//
//        logger = LoggerFactory.getLogger(DefaultCFHttpService.class);
//    }
//
//    public DefaultCFHttpService() {
//        this(DEFAULT_REQUEST_TIMEOUT);
//    }
//
//    @Override
//    int getRetryTimes() {
//        return 0;
//    }
//
//    @Override
//    int getRetryIntervalMills() {
//        return 0;
//    }
//
//}
//
//
