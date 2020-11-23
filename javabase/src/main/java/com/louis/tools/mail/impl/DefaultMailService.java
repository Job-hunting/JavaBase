package com.louis.tools.mail.impl;///*
// * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.mail.impl;
//
//import java.io.ByteArrayInputStream;
//import java.nio.charset.StandardCharsets;
//
//import javax.activation.DataSource;
//import javax.mail.internet.MimeUtility;
//import javax.mail.util.ByteArrayDataSource;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.HtmlEmail;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.baidu.ops.root.base.json.JsonUtils;
//import com.baidu.ops.root.third.mail.MailService;
//import com.baidu.ops.root.third.mail.data.MailMeta;
//
//public class DefaultMailService implements MailService {
//
//    private static final String HOST_NAME = "mail1-in.baidu.com";
//    private static final int DEFAULT_TIMEOUT_MILLS = 5000;
//    private static final String BINARY_MIME_TYPE = "application/octet-stream";
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMailService.class);
//
//    @Override
//    public void sendAttachmentMail(MailMeta mail) {
//        try {
//            sendAttachmentMailWithException(mail);
//        } catch (Exception e) {
//            LOGGER.error("send mail failed with attachmentMail:{}",
//                    e, JsonUtils.toJson(mail));
//        }
//
//    }
//
//    @Override
//    public void sendAttachmentMailWithException(MailMeta mail) throws Exception {
//        // send email
//        HtmlEmail email = new HtmlEmail();
//
//        email.setHostName(HOST_NAME);
//        int mailTimeoutMills = mail.getTimeoutMills() == null
//                ? DEFAULT_TIMEOUT_MILLS : mail.getTimeoutMills();
//        email.setSocketConnectionTimeout(mailTimeoutMills);
//        email.setSocketTimeout(mailTimeoutMills);
//        email.setCharset(StandardCharsets.UTF_8.name());
//
//        for (String s : mail.getTo()) {
//            email.addTo(s);
//        }
//        email.setFrom(mail.getFrom());
//        email.setCharset(StandardCharsets.UTF_8.toString());
//        email.setSubject(mail.getSubject());
//        email.setMsg(mail.getMsg());
//
//        // 邮件中嵌入文件，如图片
//        if (CollectionUtils.isNotEmpty(mail.getAttachMetaList())) {
//            mail.getAttachMetaList().forEach(attachMeta -> {
//                try {
//                    DataSource ds = new ByteArrayDataSource(attachMeta.getInputStream(), attachMeta.getContentType());
//                    email.embed(ds, attachMeta.getName(), attachMeta.getCid());
//                } catch (Exception e) {
//                    LOGGER.error("send mail failed with attachMeta:{}",
//                            e, JsonUtils.toJson(attachMeta));
//                }
//
//            });
//        }
//        if (CollectionUtils.isNotEmpty(mail.getCc())) {
//            for (String cc : mail.getCc()) {
//                email.addCc(cc);
//            }
//        }
//        if (StringUtils.isNotBlank(mail.getAttachmentName())) {
//            System.setProperty("mail.mime.splitlongparameters", "false");
//            String attachmentName = MimeUtility.encodeText(mail.getAttachmentName(),
//                    StandardCharsets.UTF_8.toString(), null);
//            if (StringUtils.isNotBlank(mail.getAttachmentPath())) {
//                EmailAttachment attachment = new EmailAttachment();
//                // 本地文件
//                attachment.setPath(mail.getAttachmentPath());
//                attachment.setDisposition(EmailAttachment.ATTACHMENT);
//                attachment.setDescription(attachmentName);
//                attachment.setName(attachmentName);
//                email.attach(attachment);
//            } else if (mail.getAttachmentBytes() != null) {
//                email.attach(new ByteArrayDataSource(new ByteArrayInputStream(mail.getAttachmentBytes()),
//                        BINARY_MIME_TYPE), attachmentName, attachmentName);
//            }
//        }
//
//        email.send();
//        LOGGER.info("send mail subject:{} from:{} to:{} success.", mail.getSubject(),
//                mail.getFrom(), mail.getTo());
//    }
//}
