package com.louis.tools;//package com.louis.tools;
//
//import java.io.BufferedWriter;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.List;
//
//import com.baidu.ops.root.base.common.CommonConstant;
//import com.baidu.ops.root.base.exception.BusinessException;
//import com.baidu.ops.root.base.exception.ErrorCode;
//
///**
// * CSV文件工具类
// */
//public class CsvUtil {
//
//    /**
//     * 生成CSV文件并输出为字节码
//     *
//     * @param head
//     * @param dataList
//     */
//    public static byte[] csvWrite(List<Object> head, List<List<Object>> dataList) {
//        byte[] bytes;
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try (BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(os, CommonConstant.GB_2312), 1024)) {
//            // 写入文件头部
//            writeRow(head, csvWriter);
//            // 写入文件内容
//            for (List<Object> row : dataList) {
//                writeRow(row, csvWriter);
//            }
//            csvWriter.flush();
//            bytes = os.toByteArray();
//        } catch (IOException e) {
//            throw new BusinessException(ErrorCode.SYSTEM_EXCEPTION, "csv文件创建失败");
//        }
//        return bytes;
//    }
//
//
//    /**
//     * 写一行数据方法
//     *
//     * @param row
//     * @param csvWriter
//     * @throws IOException
//     */
//    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
//        for (Object data : row) {
//            String rowStr = "\"" + data + "\",";
//            csvWriter.write(rowStr);
//        }
//        csvWriter.newLine();
//    }
//}
