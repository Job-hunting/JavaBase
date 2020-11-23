package com.louis.tools.file;//package com.louis.tools.file;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.apache.commons.io.IOUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.baidu.juping.shows.base.exception.ShowsInternalException;
//import com.google.common.collect.Lists;
//
//public final class FileUtils {
//
//    private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);
//    private static final int URL_CONNECTION_TIME_OUT = 20 * 1000;
//    private static final int MB_UNIT = 1048576;
//
//    private FileUtils() {
//        throw new IllegalStateException("FileUtils class");
//    }
//
//    public static void downloadRemoteFile(String localDir, String fileName, String url) {
//        LOG.info("start to download file {}", fileName);
//        FileOutputStream fileOutputStream = null;
//        try {
//            URL remoteUrl = new URL(url);
//            URLConnection urlConnection = remoteUrl.openConnection();
//            urlConnection.setConnectTimeout(URL_CONNECTION_TIME_OUT);
//            urlConnection.setReadTimeout(URL_CONNECTION_TIME_OUT);
//            fileOutputStream = new FileOutputStream(new File(localDir + "/" + fileName));
//            IOUtils.copyLarge(urlConnection.getInputStream(), fileOutputStream);
//        } catch (Exception e) {
//            LOG.error("download file {} failed ", fileName, e);
//            throw new ShowsInternalException("download file failed", e);
//        } finally {
//            if (fileOutputStream != null) {
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    LOG.error("close output stream failed", e);
//                }
//            }
//        }
//    }
//
//    public static List<String> readAllLinesInDir(String dirName) {
//        try (Stream<Path> walk = Files.walk(Paths.get(dirName))) {
//            List<String> result = walk.filter(Files::isRegularFile)
//                    .filter(item -> !item.getFileName().toFile().getName().startsWith(".")
//                            && !item.getFileName().toFile().getName().startsWith("crc"))
//                    .map(x -> x.toFile().getAbsolutePath()).collect(Collectors.toList());
//            return result.stream().map((String fileName) -> {
//                try {
//                    return IOUtils.readLines(new FileInputStream(fileName),
//                            StandardCharsets.UTF_8);
//                } catch (IOException e) {
//                    LOG.error("read file failed for fileName {}", dirName, e);
//                    return null;
//                }
//            }).filter(Objects::nonNull).flatMap(List::stream).collect(Collectors.toList());
//        } catch (Exception e) {
//            LOG.error("read all lines failed for dirName {}", dirName, e);
//        }
//        return Lists.newArrayList();
//    }
//
//    public static boolean checkFileSize(Long len, int limitSize) {
//        double fileSize = (double) len / MB_UNIT;
//        return fileSize < limitSize;
//    }
//}
