package com.louis.tools.mail.data;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.mail.data;
//
//import java.util.List;
//
///**
// * 帮助快速构建MailMeta
// */
//public class MailMetaBuilder {
//
//    public static final String LINE_BREAK = "<br/>";
//
//
//    /**
//     * 构建邮件
//     * @param subject 邮件主题
//     * @param lines 正文多行，行之间自动填充："<br/>"
//     * @param from 发送方
//     * @param to 接收方
//     * @param cc 抄送方，可为空
//     * @return MailMeta
//     */
//    public static MailMeta buildMail(String subject, List<String> lines, String from, List<String> to,
//                                     List<String> cc) {
//        String mailBody = String.join(LINE_BREAK, lines);
//        return buildMail(subject, mailBody, from, to, cc);
//    }
//
//    /**
//     * 构建邮件
//     * @param subject 邮件主题
//     * @param msg 正文
//     * @param from 发送方
//     * @param to 接收方
//     * @param cc 抄送方，可为空
//     * @return MailMeta
//     */
//    public static MailMeta buildMail(String subject, String msg, String from, List<String> to,
//                                     List<String> cc) {
//        MailMeta result = new MailMeta();
//        result.setSubject(subject);
//        result.setMsg(msg);
//        result.setFrom(from);
//        result.setTo(to);
//        result.setCc(cc);
//        return result;
//    }
//
//}
