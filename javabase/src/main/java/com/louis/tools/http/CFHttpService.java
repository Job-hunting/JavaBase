package com.louis.tools.http;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.http;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//
//import org.asynchttpclient.request.body.multipart.Part;
//
//public interface CFHttpService {
//
//    CompletableFuture<String> asyncPostObject(String url, Object object);
//
//    CompletableFuture<String> asyncPostObject(String url, Object object, int timeoutMills);
//
//    CompletableFuture<String> asyncPostJson(String url, String jsonStr, int timeoutMills);
//
//    CompletableFuture<String> asyncPostJson(String url, String jsonStr);
//
//    CompletableFuture<String> asyncPostJson(String url, String jsonStr,
//                                            Map<String, String> headers, int timeoutMills);
//
//    CompletableFuture<String> asyncPost(String url, Map<?, ?> params);
//
//    CompletableFuture<String> asyncPost(String url, Map<?, ?> params, int timeoutMills);
//
//    CompletableFuture<String> asyncPost(String url, Map<?, ?> params, int timeoutMills,
//                                        boolean printLog);
//
//    CompletableFuture<String> asyncPost(String url, Map<?, ?> params, int timeoutMills,
//                                        Map<String, String> headers, boolean printLog);
//
//    CompletableFuture<String> asyncPostBodyParts(String url, List<Part> parts);
//
//    CompletableFuture<String> asyncPostBodyParts(String url, List<Part> parts, int timeoutMills);
//
//    CompletableFuture<String> asyncGet(String url, Map<?, ?> params);
//
//    CompletableFuture<String> asyncGet(String url, Map<?, ?> params, int timeoutMills);
//
//    CompletableFuture<String> asyncGet(String url, Map<?, ?> params, Map<String, String> headers,
//                                       int timeoutMills);
//
//    CompletableFuture<String> asyncGetWithAuth(String url, Map<?, ?> params, int timeoutMills, String key,
//                                               String token);
//}
