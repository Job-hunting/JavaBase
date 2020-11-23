package com.louis.tools.http;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.http;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//
//import javax.annotation.PreDestroy;
//
//import org.apache.commons.collections4.MapUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.HttpHeaders;
//import org.asynchttpclient.AsyncHttpClient;
//import org.asynchttpclient.BoundRequestBuilder;
//import org.asynchttpclient.request.body.multipart.Part;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.baidu.ops.root.base.json.JsonUtils;
//import com.google.common.base.Stopwatch;
//import com.google.common.collect.Maps;
//
//public abstract class AbstractCFHttpService implements CFHttpService {
//    protected static final int DEFAULT_REQUEST_TIMEOUT = 4000;
//    protected static final int DEFAULT_RETRY_TIMES = 2;
//    private static final Charset CHARSET = StandardCharsets.UTF_8;
//    private static final int MAX_LOG_CONTENT_LENGTH = 10000;
//    protected Logger logger = LoggerFactory.getLogger(AbstractCFHttpService.class);
//    protected AsyncHttpClient asyncHttpClient;
//
//    @Override
//    public CompletableFuture<String> asyncPostObject(String url, Object object) {
//        return asyncPostObject(url, object, DEFAULT_REQUEST_TIMEOUT);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPostObject(String url, Object object, int timeoutMills) {
//        return asyncPostJson(url, JsonUtils.toJson(object), timeoutMills);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPostJson(String url, String jsonStr) {
//        return asyncPostJson(url, jsonStr, DEFAULT_REQUEST_TIMEOUT);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPostJson(String url, String jsonStr, int timeoutMills) {
//        return asyncPostJson(url, jsonStr, Maps.newHashMap(), timeoutMills);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPostJson(String url, String jsonStr,
//                                                   Map<String, String> headers, int timeoutMills) {
//        if (jsonStr.length() > MAX_LOG_CONTENT_LENGTH) {
//            logger.info("Start asyncPostJson: {} with param ignored(too large) and timeout:{}", url, timeoutMills);
//        } else {
//            logger.info("Start asyncPostJson: {} with {} and time out:{}", url, jsonStr, timeoutMills);
//        }
//        BoundRequestBuilder boundRequestBuilder = asyncHttpClient.preparePost(url)
//                .setCharset(CHARSET)
//                .setRequestTimeout(timeoutMills)
//                .setReadTimeout(timeoutMills)
//                .setHeader("Content-Type", "application/json")
//                .setBody(jsonStr);
//        if (MapUtils.isNotEmpty(headers)) {
//            headers.forEach(boundRequestBuilder::setHeader);
//        }
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        return retry(url, jsonStr, boundRequestBuilder, stopwatch, 0);
//    }
//
//    private CompletableFuture<String> retry(String url, String jsonStr,
//                                            BoundRequestBuilder boundRequestBuilder, Stopwatch stopwatch,
//                                            int retry) {
//        final int retryFinal = retry;
//        return boundRequestBuilder
//                .execute(new AsyncHandler(url, stopwatch, jsonStr))
//                .toCompletableFuture()
//                .whenCompleteAsync((response, throwable) -> {
//                    if (needRetry(retryFinal, throwable)) {
//                        logger.info("asyncPostJson: {} with {} retry {} times.", url, jsonStr, retryFinal);
//                        retry(url, jsonStr, boundRequestBuilder, stopwatch, retryFinal + 1);
//                    }
//                })
//                .thenApply(res -> res.getResponseBody(CHARSET));
//    }
//
//    private boolean needRetry(int retryTimes, Throwable t) {
//        if (retryTimes < getRetryTimes() && t != null) {
//            if (getRetryIntervalMills() > 0 && retryTimes > 0) {
//                try {
//                    Thread.sleep(getRetryIntervalMills());
//                    logger.info("retry {} after sleep {} mills.", retryTimes, getRetryIntervalMills());
//                } catch (InterruptedException e) {
//                    logger.warn("retry sleep meeting exception.", e);
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPost(String url, Map<?, ?> params) {
//        return asyncPost(url, params, DEFAULT_REQUEST_TIMEOUT);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPost(String url, Map<?, ?> params, int timeoutMills) {
//        return asyncPost(url, params, timeoutMills, true);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPost(String url, Map<?, ?> params, int timeoutMills,
//                                               boolean printLog) {
//        return asyncPost(url, params, timeoutMills, null, printLog);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPost(String url, Map<?, ?> params, int timeoutMills,
//                                               Map<String, String> headers, boolean printLog) {
//        if (printLog) {
//            logger.info("Start asyncPost url: {} with param: {}", url, params);
//        }
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        BoundRequestBuilder builder = asyncHttpClient.preparePost(url)
//                .setCharset(CHARSET)
//                .setRequestTimeout(timeoutMills)
//                .setReadTimeout(timeoutMills);
//        for (Map.Entry<?, ?> entry : params.entrySet()) {
//            if (entry.getValue() != null) {
//                builder.addFormParam(entry.getKey().toString(), getValueWithNull2Empty(entry.getValue()));
//            }
//        }
//        if (MapUtils.isNotEmpty(headers)) {
//            headers.forEach(builder::setHeader);
//        }
//
//        return retry(url, params, builder, stopwatch, 0);
//    }
//
//    private CompletableFuture<String> retry(String url, Map<?, ?> params,
//                                            BoundRequestBuilder builder, Stopwatch stopwatch,
//                                            int retry) {
//        final int retryFinal = retry;
//        return builder.execute(new AsyncHandler(url, stopwatch, params))
//                .toCompletableFuture()
//                .whenCompleteAsync((response, throwable) -> {
//                    if (needRetry(retryFinal, throwable)) {
//                        logger.info("asyncPostJson: {} with {} retry {} times.", url, JsonUtils.toJson(params),
//                                retryFinal);
//                        retry(url, params, builder, stopwatch, retryFinal + 1);
//                    }
//                })
//                .thenApply(res -> res.getResponseBody(CHARSET));
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPostBodyParts(String url, List<Part> parts) {
//        return asyncPostBodyParts(url, parts, DEFAULT_REQUEST_TIMEOUT);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncPostBodyParts(String url, List<Part> parts, int timeoutMills) {
//        logger.info("Start asyncPostBodyParts url: {}", url);
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        BoundRequestBuilder builder = asyncHttpClient.preparePost(url)
//                .setCharset(CHARSET)
//                .setRequestTimeout(timeoutMills)
//                .setReadTimeout(timeoutMills)
//                .setBodyParts(parts);
//
//        return retry(url, parts, builder, stopwatch, 0);
//    }
//
//    private CompletableFuture<String> retry(String url, List<Part> parts,
//                                            BoundRequestBuilder builder, Stopwatch stopwatch,
//                                            int retry) {
//        final int retryFinal = retry;
//        return builder.execute(new AsyncHandler(url, stopwatch, parts))
//                .toCompletableFuture()
//                .whenCompleteAsync((response, throwable) -> {
//                    if (needRetry(retryFinal, throwable)) {
//                        logger.info("asyncPostJson: {} with {} retry {} times.", url, JsonUtils.toJson(parts),
//                                retryFinal);
//                        retry(url, parts, builder, stopwatch, retryFinal + 1);
//                    }
//                })
//                .thenApply(res -> res.getResponseBody(CHARSET));
//    }
//
//    @Override
//    public CompletableFuture<String> asyncGet(String url, Map<?, ?> params) {
//        return asyncGet(url, params, DEFAULT_REQUEST_TIMEOUT);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncGet(String url, Map<?, ?> params, int timeoutMills) {
//        return asyncGetWithAuth(url, params, timeoutMills, null, null);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncGet(String url, Map<?, ?> params, Map<String, String> headers,
//                                              int timeoutMills) {
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        logger.info("Start asyncGet url: {} with param: {} with headers:{}", url, params, headers);
//
//        BoundRequestBuilder builder = asyncHttpClient.prepareGet(url)
//                .setRequestTimeout(timeoutMills).setReadTimeout(timeoutMills);
//        for (Map.Entry<?, ?> entry : params.entrySet()) {
//            builder.addQueryParam(entry.getKey().toString(), getValueWithNull2Empty(entry.getValue()));
//        }
//
//        if (MapUtils.isNotEmpty(headers)) {
//            headers.forEach(builder::setHeader);
//        }
//
//        return retry(url, params, builder, stopwatch, 0);
//    }
//
//    @Override
//    public CompletableFuture<String> asyncGetWithAuth(String url, Map<?, ?> params, int timeoutMills, String key,
//                                                      String token) {
//        Map<String, String> headers = new HashMap<>();
//        if (StringUtils.isNotBlank(token)) {
//            String encoded = Base64.getEncoder().encodeToString((key + ':' + token).getBytes(StandardCharsets.UTF_8));
//            headers.put(HttpHeaders.AUTHORIZATION, "Basic " + encoded);
//        }
//
//        return asyncGet(url, params, headers, timeoutMills);
//    }
//
//    private String getValueWithNull2Empty(Object value) {
//        return value == null ? StringUtils.EMPTY : value.toString();
//    }
//
//    abstract int getRetryTimes();
//
//    abstract int getRetryIntervalMills();
//
//    @PreDestroy
//    public void destroy() {
//        try {
//            asyncHttpClient.close();
//        } catch (IOException e) {
//            logger.error("asyncHttpClient close meeting exception.", e);
//        }
//    }
//}
