package com.harish.ticketgen;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelNumberHighlight {

    public static FileInputStream file;
    public static String filePath = "C:\\Users\\1021053\\Desktop\\Tickets_26Apr_2020 - Copy.xlsx";

    static {
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void highlightThePickedNumber(int calledNumber) {

        int ticketLength = 3;
        int ticketColumLength = 9;

        XSSFSheet sheet = workbook.getSheet("Tickets_26Apr2020");

        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);

        int numberOFTickets = 200;

        for(int k = 0 ; k < numberOFTickets ; k++ ) {

            int rowNum = k*5 + 1;
            // One ticket
            for (int i = 0; i < ticketLength ; i++) {
                Row row = sheet.getRow(++rowNum);
                for (int j = 0; j < ticketColumLength; j++) {
                    Cell cell = row.getCell(j+1);
                    if(cell.getCellType() == CellType.NUMERIC) {
                        if ((int)cell.getNumericCellValue() == calledNumber ) {
                            cell.setCellStyle(style);
                    }
                    }
                }
            }
        }

        try (
                FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
