package com.louis.tools.zip;//package com.louis.tools.zip;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//import java.util.zip.CRC32;
//import java.util.zip.CheckedOutputStream;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//import java.util.zip.ZipOutputStream;
//
//import com.baidu.juping.shows.base.exception.ShowsInternalException;
//
///**
// * 压缩文件工具类
// */
//public class ZipUtils {
//
//    static final int BUFFER = 8192;
//    private static final int ZIP_BUFFER = 1024;
//
//    private ZipUtils() {
//        // Utility classes should not have public constructors
//    }
//
//    /**
//     * 压缩单个或多文件方法
//     *
//     * @param zipPath     压缩后的文件路径
//     * @param srcPathName 要压缩的文件路径
//     *                    参数srcPathName也可以定义成数组形式，需调用方把参数封装到数组中传过来即可
//     * (1)如果在zip压缩文件中不需要一级文件目录，定义String basedir = "";
//     * 下面的compress方法中当判断文件file是目录后不需要加上basedir = basedir + file.getName() + File.separator;
//     * (2)如果只是想在压缩后的zip文件里包含一级文件目录，不包含二级以下目录，
//     * 直接在这定义String basedir = file.getName() + File.separator;
//     * 下面的compress方法中当判断文件file是目录后不需要加上basedir = basedir + file.getName() + File.separator;
//     * (3)如果想压缩后的zip文件里包含一级文件目录，也包含二级以下目录，即zip文件里的目录结构和原文件一样
//     * 在此定义String basedir = "";
//     * 下面的compress方法中当判断文件file是目录后需要加上basedir = basedir + file.getName() + File.separator;
//     */
//    public static File compress(String zipPath, List<String> srcPathName) {
//        File zipFile = new File(zipPath);
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
//            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());
//            ZipOutputStream out = new ZipOutputStream(cos);
//            for (String srcPath : srcPathName) {
//                File file = new File(srcPath);
//                if (!file.exists()) {
//                    throw new RuntimeException(srcPath + "不存在！");
//                }
//                String basedir = "";
//                compress(file, out, basedir);
//            }
//            out.close();
//        } catch (Exception e) {
//            throw new ShowsInternalException(e);
//        }
//        return zipFile;
//    }
//
//    private static void compress(File file, ZipOutputStream out, String basedir) {
//        /*
//         * 判断是目录还是文件
//         */
//        if (file.isDirectory()) {
//            basedir += file.getName() + File.separator;
//            compressDirectory(file, out, basedir);
//        } else {
//            System.out.println("压缩：" + basedir + file.getName());
//            compressFile(file, out, basedir);
//        }
//    }
//
//    /**
//     * 压缩一个目录
//     */
//    private static void compressDirectory(File dir, ZipOutputStream out, String basedir) {
//        if (!dir.exists()) {
//            return;
//        }
//        File[] files = dir.listFiles();
//        for (int i = 0; i < files.length; i++) {
//            compress(files[i], out, basedir);
//        }
//    }
//
//    /**
//     * 压缩一个文件
//     */
//    private static void compressFile(File file, ZipOutputStream out, String basedir) {
//        if (!file.exists()) {
//            return;
//        }
//        try {
//            BufferedInputStream bis = new BufferedInputStream(
//                    new FileInputStream(file));
//            ZipEntry entry = new ZipEntry(basedir + file.getName());
//            out.putNextEntry(entry);
//            int count;
//            byte[] data = new byte[BUFFER];
//            while ((count = bis.read(data, 0, BUFFER)) != -1) {
//                out.write(data, 0, count);
//            }
//            bis.close();
//        } catch (Exception e) {
//            throw new ShowsInternalException(e);
//        }
//    }
//
//    public static void unzip(String path, String target) throws IOException {
//        File targetfolder = new File(target);
//        ZipInputStream zi = new ZipInputStream(new FileInputStream(path));
//        ZipEntry ze = null;
//        FileOutputStream fo = null;
//        byte[] buff = new byte[ZIP_BUFFER];
//        int len;
//        while ((ze = zi.getNextEntry()) != null) {
//            File file = new File(targetfolder, ze.getName());
//            if (!file.getParentFile().exists()) {
//                file.getParentFile().mkdirs();
//            }
//            if (ze.isDirectory()) {
//                file.mkdir();
//            } else {
//                fo = new FileOutputStream(file);
//                while ((len = zi.read(buff)) > 0) {
//                    fo.write(buff, 0, len);
//                }
//                fo.close();
//            }
//            zi.closeEntry();
//        }
//        zi.close();
//    }
//
//}
