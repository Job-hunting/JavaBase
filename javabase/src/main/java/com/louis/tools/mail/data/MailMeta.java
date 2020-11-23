package com.louis.tools.mail.data;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.mail.data;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 邮件内容，建议使用{@link MailMetaBuilder}帮助类快速构造
// */
//public class MailMeta {
//
//    private String from;
//    private List<String> to = new ArrayList<>();
//    private List<String> cc = new ArrayList<>();
//    private String subject;
//    private String msg;
//    private String attachmentPath;  // 可选
//    private String attachmentName;  // 可选
//    private byte[] attachmentBytes;  // 可选
//    private Integer timeoutMills;  // 可选 默认5s
//
//    private List<AttachMeta> attachMetaList;
//
//    public Integer getTimeoutMills() {
//        return timeoutMills;
//    }
//
//    public void setTimeoutMills(Integer timeoutMills) {
//        this.timeoutMills = timeoutMills;
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public List<String> getTo() {
//        return to;
//    }
//
//    public void setTo(List<String> to) {
//        this.to = to;
//    }
//
//    public List<String> getCc() {
//        return cc;
//    }
//
//    public void setCc(List<String> cc) {
//        this.cc = cc;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public String getAttachmentPath() {
//        return attachmentPath;
//    }
//
//    public void setAttachmentPath(String attachmentPath) {
//        this.attachmentPath = attachmentPath;
//    }
//
//    public String getAttachmentName() {
//        return attachmentName;
//    }
//
//    public void setAttachmentName(String attachmentName) {
//        this.attachmentName = attachmentName;
//    }
//
//    public byte[] getAttachmentBytes() {
//        return attachmentBytes;
//    }
//
//    public void setAttachmentBytes(byte[] attachmentBytes) {
//        this.attachmentBytes = attachmentBytes;
//    }
//
//    public List<AttachMeta> getAttachMetaList() {
//        return attachMetaList;
//    }
//
//    public void setAttachMetaList(List<AttachMeta> attachMetaList) {
//        this.attachMetaList = attachMetaList;
//    }
//}
