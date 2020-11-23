package com.louis.tools.cmd;///*
// * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.cmd;
//
//public class ExecCmdResult {
//
//    public ExecCmdResult(boolean isTimeOut, Integer returnCode) {
//        this.isTimeOut = isTimeOut;
//        this.returnCode = returnCode;
//    }
//
//    /**
//     * 是否超时
//     */
//    private boolean isTimeOut;
//
//    /**
//     * 进程返回code，如果超时returnCode为null
//     */
//    private Integer returnCode;
//
//    public boolean isSuccess() {
//        return !isTimeOut && returnCode == 0;
//    }
//
//    public boolean isTimeOut() {
//        return isTimeOut;
//    }
//
//    public Integer getReturnCode() {
//        return returnCode;
//    }
//}
