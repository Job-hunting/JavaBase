package com.louis.tools.http;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.http;
//
//import org.apache.http.HttpStatus;
//import org.asynchttpclient.AsyncCompletionHandler;
//import org.asynchttpclient.Response;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.baidu.ops.root.base.json.JsonUtils;
//import com.baidu.ops.root.base.utils.CommonUtils;
//import com.google.common.base.Stopwatch;
//
//public class AsyncHandler extends AsyncCompletionHandler<Response> {
//
//    private static final Logger logger = LoggerFactory.getLogger(AsyncHandler.class);
//    private static final String URL_PARAM_SPLIT = "\\?";
//
//    private String url;
//    private Stopwatch stopwatch;
//    private String domain;
//    private String path;
//    private Object request;
//
//    public AsyncHandler(String url, Stopwatch stopwatch, Object request) {
//        this.url = url;
//        this.stopwatch = stopwatch;
//        String[] domainAndPath = CommonUtils.fetchURLDomainAndPath(url);
//        domain = domainAndPath[0];
//        path = domainAndPath[1];
//        this.request = request;
//    }
//
//    @Override
//    public Response onCompleted(Response response) throws Exception {
//        logger.info("Finish asyncHttp time: {}, url is: {}",
//                stopwatch.toString(), url);
//        logger.info("HttpPath={} Host={} HttpCode={} Status=SUCC Spend={}",
//                path, domain,
//                response.getStatusCode(), stopwatch.toString());
//
//        if (response.getStatusCode() != 200) {
//            logger.warn("Async http response status code is {}.", response.getStatusCode());
//        }
//        return response;
//    }
//
//    @Override
//    public void onThrowable(Throwable t) {
//        logger.warn("Finish asyncHttp url failed with time: {}, url is: {}",
//                stopwatch.toString(), url);
//        logger.info("HttpPath={} Host={} HttpCode={} Status=ERR Spend={}",
//                path, domain, HttpStatus.SC_INTERNAL_SERVER_ERROR,
//                stopwatch.toString());
//        String urlWithoutParam = url.split(URL_PARAM_SPLIT)[0];
//        logger.error(
//                "asyncPostJson url: {} meeting exception.",
//                t, urlWithoutParam, JsonUtils.toJson(request), stopwatch.toString());
//        super.onThrowable(t);
//    }
//}