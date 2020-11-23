package com.louis.tools.excel;///*
// * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
// */
//package com.louis.tools.excel;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.NumberFormat;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//public final class ExcelUtils {
//
//    private static final Logger LOG = LoggerFactory.getLogger(ExcelUtils.class);
//    private static final int DEFAULT_EXCEL_FONT_SIZE = 12;
//    private static final NumberFormat NUMBER_FORMAT = new NumberFormat("#0");
//    private static final WritableCellFormat NUMBER_CELL_FORMAT = new WritableCellFormat(NUMBER_FORMAT);
//    private static final WritableCellFormat CELL_FORMAT =
//            new WritableCellFormat(new WritableFont(WritableFont.TIMES, DEFAULT_EXCEL_FONT_SIZE, WritableFont.NO_BOLD));
//    private static final String SHEET_NAME = "招商合作信息";
//
//    private ExcelUtils() {
//        throw new IllegalStateException("ExcelUtils class");
//    }
//
//    public static InputStream gen(List<List<String>> data) {
//        Map<String, List<List<String>>> sheetDataMap = Maps.newHashMap();
//        sheetDataMap.put(SHEET_NAME, data);
//        return gen(sheetDataMap, Lists.newArrayList(SHEET_NAME));
//    }
//
//    public static InputStream gen(Map<String, List<List<String>>> sheetDataMap, List<String> sheetNames) {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        WritableWorkbook book = null;
//        try {
//            book = Workbook.createWorkbook(outputStream);
//            for (int index = 0; index < sheetNames.size(); index++) {
//                WritableSheet sheet = book.createSheet(sheetNames.get(index), index);
//                List<List<String>> data = sheetDataMap.get(sheetNames.get(index));
//                for (int rowNo = 0; rowNo < data.size(); rowNo++) {
//                    addOneLine(sheet, rowNo, data.get(rowNo));
//                }
//            }
//            book.write();
//        } catch (Exception e) {
//            LOG.error("generate excel files meeting exception.", e);
//        } finally {
//            try {
//                if (book != null) {
//                    book.close();
//                }
//            } catch (Exception e) {
//                LOG.error("generate excel files meeting exception.", e);
//            }
//        }
//        try {
//            return new ByteArrayInputStream(outputStream.toByteArray());
//        } finally {
//            try {
//                outputStream.close();
//            } catch (IOException e) {
//                LOG.error("generate excel files meeting exception.", e);
//            }
//        }
//    }
//
//    private static void addOneLine(WritableSheet sheet, Integer rowNo, List<String> lines) throws Exception {
//        for (int colNo = 0; colNo < lines.size(); colNo++) {
//            try {
//                Long value = Long.valueOf(lines.get(colNo));
//                sheet.addCell(new Number(colNo, rowNo, value, NUMBER_CELL_FORMAT));
//            } catch (Exception e) {
//                LOG.error("addOneLine meeting exception.", e);
//                sheet.addCell(new Label(colNo, rowNo, lines.get(colNo), CELL_FORMAT));
//            }
//        }
//
//    }
//}