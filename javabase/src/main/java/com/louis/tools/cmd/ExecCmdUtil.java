package com.louis.tools.cmd;///*
// * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.cmd;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.util.concurrent.TimeUnit;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.baidu.juping.root.base.error.BusinessException;
//import com.baidu.juping.root.base.error.ErrorCode;
//
//public class ExecCmdUtil {
//
//    private static final Logger logger = LoggerFactory.getLogger(ExecCmdUtil.class);
//
//    private ExecCmdUtil() {
//        // Utility classes should not have public constructors
//    }
//
//    /**
//     * 执行脚本命令
//     * @param shellFile shell脚本
//     * @param timeout 超时时间，秒，超时后自动kill。
//     * @param unit the time unit of the {@code timeout} argument
//     * @param logFile 日志数据文件，若为null，输出到标准输出流和标准错误流
//     * @return ExecCmdResult
//     */
//    public static ExecCmdResult runShellFile(Path shellFile, long timeout, TimeUnit unit, Path logFile) {
//        return exec("sh " + shellFile.toAbsolutePath().toString(), timeout, unit, logFile);
//    }
//
//    public static ExecCmdResult exec(String command, long timeout, TimeUnit unit, Path logFile) {
//        Process process;
//        try {
//            process = Runtime.getRuntime().exec(command);
//        } catch (IOException e) {
//            throw new BusinessException(ErrorCode.SYSTEM_EXCEPTION.getCode(), String.format("exec:%s failed", command),
//                    e);
//        }
//        // 提前输出防止假死
//        // https://blog.csdn.net/Easy_____/article/details/78436710
//        GobblerThread errorGobbler = new GobblerThread(
//                process.getErrorStream(), true, logFile);
//        GobblerThread outputGobbler = new GobblerThread(
//                process.getInputStream(), true, logFile);
//        errorGobbler.start();
//        outputGobbler.start();
//        boolean isTimeOut;
//        Integer returnCode = null;
//        try {
//            isTimeOut = !process.waitFor(timeout, unit);
//        } catch (InterruptedException e) {
//            logger.error(String.format("exec:%s interrupted", command), e);
//            isTimeOut = true;
//        }
//        logger.info("exec command :{} and isTimeOut:{}", command, isTimeOut);
//        if (isTimeOut) {
//            // 如果没有结束则结束进程
//            process.destroyForcibly();
//        } else {
//            returnCode = process.exitValue();
//        }
//        return new ExecCmdResult(isTimeOut, returnCode);
//    }
//
//}
