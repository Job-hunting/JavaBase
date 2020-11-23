package com.louis.tools.file;

import java.io.File;

/**
 * @author duansaisai
 * @date 2020-08-20 10:24
 * 修改文件名，去掉多余的名称
 * 参考博客：https://www.cnblogs.com/libin6505/p/11346731.html
 */
public class RenameFile {
    public static void main(String[] args) {
        recursiveTraversalFolder("/Users/apple/JavaBase/javabase/src/main/java/com/louis/designPattern");
    }

    private static void rename(String path) {
        File file = new File(path);
        File[] listfile = file.listFiles();
        for (int i = 0; i < listfile.length; i++) {
            String oldfileName = listfile[i].getName();
            File parentPath = listfile[i].getParentFile();
            String newFileName = oldfileName.split("【")[0] + "" + ".java";
            listfile[i].renameTo(new File(parentPath + "/" + newFileName));
        }
    }

    public static void recursiveTraversalFolder(String path) {
        File folder = new File(path);
        if (folder.exists()) {
            File[] fileArr = folder.listFiles();
            if (null == fileArr || fileArr.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                File newDir = null;//文件所在文件夹路径+新文件名
                String newName = "";//新文件名
                String fileName = null;//旧文件名
                File parentPath = new File("");//文件所在父级路径
                for (File file : fileArr) {
                    if (file.isDirectory()) {//是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
                        System.out.println("文件夹:" + file.getAbsolutePath() + "，继续递归！");
                        recursiveTraversalFolder(file.getAbsolutePath());
                    } else {//是文件，判断是否需要重命名
                        fileName = file.getName();
                        parentPath = file.getParentFile();
                        if (fileName.contains("ctokey.com")) {//文件名包含需要被替换的字符串

                            newName = fileName.split("【")[0] + "" + ".java";//新名字
                            newDir = new File(parentPath + "/" + newName);//文件所在文件夹路径+新文件名
                            file.renameTo(newDir);//重命名
                            System.out.println("修改后：" + newDir);
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
