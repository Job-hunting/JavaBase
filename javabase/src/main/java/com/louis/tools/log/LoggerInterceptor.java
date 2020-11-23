package com.louis.tools.log;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.log;
//
//import java.util.concurrent.TimeUnit;
//
//import org.aopalliance.intercept.MethodInvocation;
//import org.apache.commons.lang3.ClassUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.reflect.FieldUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.ProxyMethodInvocation;
//import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
//
//import com.baidu.ops.root.base.json.JsonUtils;
//import com.google.common.base.Stopwatch;
//
///**
// * The interceptor help a method log out,
// * which contains the status and time of the method.
// *
// * @see LoggerOut
// * @see LoggerFormat
// */
//@Aspect
//public class LoggerInterceptor {
//    private static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
//
//    // Log format
//    private static final String FORMAT = "Call={} Request={} Response={} Status={} ERR={} Spend={}";
//
//    // Status
//    private static final String OK = "SUCC";
//    private static final String ERR = "ERR";
//
//    /**
//     * Use aspect to logout
//     *
//     * @param mi
//     *
//     * @return
//     *
//     * @throws Throwable
//     */
//    @Around("@annotation(com.baidu.ops.root.base.aop.log.LoggerOut)")
//    public Object loggerOut(ProceedingJoinPoint mi) throws Throwable {
//        // 判断Annotation是否需要记录日志
//        ProxyMethodInvocation method =
//                (ProxyMethodInvocation) FieldUtils.readDeclaredField((MethodInvocationProceedingJoinPoint) mi,
//                        "methodInvocation", true);
//        LoggerOut loggerOut = method.getMethod().getAnnotation(LoggerOut.class);
//
//        String methodSimpleInfo = getMethodSimpleName(method);
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        try {
//            Object result = mi.proceed();
//            if ((!logger.isDebugEnabled() && loggerOut.debug())) {
//                return result;
//            }
//            Object response = StringUtils.EMPTY;
//            if (!loggerOut.onlyReq()) {
//                response = loggerOut.format() == LoggerFormat.JSON ? JsonUtils.toJson(result) : result;
//            }
//            logger.info(FORMAT, methodSimpleInfo, loggerOut.onlyResp() ? null : mi.getArgs(), response, OK, null,
//                    stopwatch.elapsed(TimeUnit.MILLISECONDS));
//            return result;
//        } catch (Throwable t) {
//            logger.warn(FORMAT, methodSimpleInfo, loggerOut.onlyResp() ? null : mi.getArgs(), null, ERR, t,
//                    stopwatch.elapsed(TimeUnit.MILLISECONDS));
//            logger.error(t.getMessage(), t);
//            throw t;
//        }
//    }
//
//    /**
//     * Get method name as "$ClassName.$methodName"
//     *
//     * @param mi
//     *
//     * @return
//     */
//    private static String getMethodSimpleName(MethodInvocation mi) {
//        return new StringBuilder(ClassUtils.getSimpleName(mi.getThis().getClass())).append(".")
//                .append(mi.getMethod().getName()).toString();
//    }
//}
