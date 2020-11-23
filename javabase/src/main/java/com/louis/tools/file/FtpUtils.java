package com.louis.tools.file;///*
// * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.file;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPReply;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public final class FtpUtils {
//
//    private static Logger LOG = LoggerFactory.getLogger(FtpUtils.class);
//    private static final String DEFAULT_USERNAME = "anonymous";
//    private static final String DEFAULT_PASSWORD = StringUtils.EMPTY;
//    private static final int BUFFER_SIZE = 10485760;
//    private static final int KEEP_ALIVE_SECONDS = 5;
//
//    private FtpUtils() {
//        throw new IllegalStateException("FtpUtils class");
//    }
//
//    /**
//     * Description: 从FTP服务器下载文件
//     *
//     * @param remotePath FTP服务器上的相对路径
//     * @param localPath  下载后保存到本地的路径
//     */
//    public static boolean download(String url, String remotePath, String remoteFileName,
//                                   String localFileName, String localPath) {
//        return download(url, 0, DEFAULT_USERNAME, DEFAULT_PASSWORD,
//                remotePath, remoteFileName, localFileName, localPath);
//    }
//
//    public static boolean download(String host, int timeout, String userName, String password,
//                                   String remotePath, String remoteFileName, String localFileName, String localPath) {
//        boolean success = false;
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.setBufferSize(BUFFER_SIZE);
//        LOG.info("start to download from host {} in path {} to filename {} in local path {}", host, remotePath,
//                remoteFileName, localPath);
//        try {
//            int reply;
//            if (timeout != 0) {
//                ftpClient.setDefaultTimeout(timeout);
//                ftpClient.setConnectTimeout(timeout);
//                ftpClient.setDataTimeout(timeout);
//                ftpClient.setControlKeepAliveTimeout(KEEP_ALIVE_SECONDS);
//            }
//            ftpClient.connect(host);
//            ftpClient.login(userName, password);
//            reply = ftpClient.getReplyCode();
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//            ftpClient.setRemoteVerificationEnabled(false);
//            LOG.info("Ftp server replay {}", reply);
//            if (!FTPReply.isPositiveCompletion(reply)) {
//                ftpClient.disconnect();
//                LOG.error("Ftp server connect failed");
//                return false;
//            }
//            ftpClient.changeWorkingDirectory(remotePath);
//            ftpClient.enterLocalPassiveMode();
//            File localFile = new File(localPath + "/" + localFileName);
//            OutputStream is = new FileOutputStream(localFile);
//            ftpClient.retrieveFile(remoteFileName, is);
//            is.close();
//            ftpClient.logout();
//            success = true;
//        } catch (IOException e) {
//            LOG.error("Connect ftp client failed", e);
//        } finally {
//            if (ftpClient.isConnected()) {
//                try {
//                    ftpClient.disconnect();
//                } catch (IOException e) {
//                    LOG.error("Disconnect ftp client failed", e);
//                }
//            }
//        }
//        return success;
//    }
//
//    /**
//     * Description: 判断FTP服务器文件是否存在
//     *
//     * @param remotePath FTP服务器上的相对路径
//     */
//    public static boolean isFileExist(String url, String remotePath, String remoteFileName) {
//        boolean success = false;
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.setBufferSize(BUFFER_SIZE);
//        LOG.info("ftp host {}, path {}, filename {} ", url, remotePath, remoteFileName);
//        try {
//            int reply;
//            ftpClient.connect(url);
//            ftpClient.login(DEFAULT_USERNAME, DEFAULT_PASSWORD);
//            reply = ftpClient.getReplyCode();
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//            ftpClient.setRemoteVerificationEnabled(false);
//            LOG.info("Ftp server replay {}", reply);
//            if (!FTPReply.isPositiveCompletion(reply)) {
//                ftpClient.disconnect();
//                LOG.error("Ftp server connect failed");
//                return false;
//            }
//            ftpClient.changeWorkingDirectory(remotePath);
//            ftpClient.enterLocalPassiveMode();
//            InputStream is = ftpClient.retrieveFileStream(remoteFileName);
//            if (is == null || !FTPReply.isPositiveCompletion(reply)) {
//                ftpClient.disconnect();
//                LOG.error("remote file not exist, file: {}", remoteFileName);
//                return false;
//            }
//            is.close();
//            ftpClient.logout();
//            success = true;
//        } catch (IOException e) {
//            LOG.error("Connect ftp client failed", e);
//        } finally {
//            if (ftpClient.isConnected()) {
//                try {
//                    ftpClient.disconnect();
//                } catch (IOException e) {
//                    LOG.error("Disconnect ftp client failed", e);
//                }
//            }
//        }
//        return success;
//    }
//}
