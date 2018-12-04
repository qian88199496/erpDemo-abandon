package com.erp.common.util;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

public class ExportUtils {
    /**
     * 设置sheet表头信息
     *
     * @param headers
     * @param title
     */
    public static HSSFSheet sheet;

    public static void outputHeaders(String[] headers, HSSFWorkbook workbook, String title) {
        sheet = workbook.createSheet(title);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 在第一行创建表头
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            // 设置列宽
            sheet.setColumnWidth(i, 4000);
            // 对第一行创建列，对每一列进行赋值和加样式
            HSSFCell headerCell = row.createCell(i);
            headerCell.setCellStyle(style);
            headerCell.setCellValue(headers[i]);
        }
    }

    /**
     * 设置每行数据
     *
     * @param headers
     * @param colums
     * @param sheet
     * @param rowIndex
     */
    public static void outputColums(String[] headers, List<?> colums, HSSFWorkbook workbook, int rowIndex) {

        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(CellStyle.BORDER_THIN);
        style2.setBorderLeft(CellStyle.BORDER_THIN);
        style2.setBorderRight(CellStyle.BORDER_THIN);
        style2.setBorderTop(CellStyle.BORDER_THIN);
        style2.setAlignment(CellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        HSSFRow row;
        int headerSize = headers.length;
        int columnSize = colums.size();
        // 循环多少行
        for (int i = 0; i < columnSize; i++) {
            // 从rowIndex行开始创建行
            row = sheet.createRow(rowIndex + i);
            Object obj = colums.get(i);
            // 循环多少列
            for (int j = 0; j < headerSize; j++) {
                Object value = getFieldValueByName(headers[j], obj);
                HSSFCell cell = row.createCell(j);
                cell.setCellStyle(style2);

                if (value == null) {
                    cell.setCellValue("");
                }
                else {
                    cell.setCellValue(value.toString());
                }

            }
        }
    }

    /**
     * 根据对象的属性获取值
     *
     * @param string
     * @param obj
     * @return
     */
    private static Object getFieldValueByName(String fieldName, Object obj) {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + fieldName.substring(1);
        try {
            Method method = obj.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(obj, new Object[] {});
            return value;
        }
        catch (Exception e) {
            //// System.out.println("属性不存在");
            return null;
        }

    }

}
