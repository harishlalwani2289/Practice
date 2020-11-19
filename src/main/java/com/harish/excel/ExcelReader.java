package com.harish.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Date;

public class ExcelReader {
    public static void main(String[] args) throws IOException {
        writeIntoExcel("birthday.xls");
        readFromExcel("birthday.xls");
    }

    private static void readFromExcel(String file) throws IOException{
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
        HSSFRow row = myExcelSheet.getRow(0);

        String name = row.getCell(0).getStringCellValue();
        Double credit = row.getCell(1).getNumericCellValue();

        System.out.println(name + " " + credit);



    }

    private static void writeIntoExcel(String file) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");

        Row row = sheet.createRow(0);

        Cell name = row.createCell(0);
        name.setCellValue("Harish");

        Cell credit = row.createCell(1);
        //DataFormat format = book.createDataFormat();
        //CellStyle dateStyle = book.createCellStyle();
        //dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        //birthday.setCellStyle(dateStyle);

        //birthday.setCellValue(new Date(2019, 12, 12));
        credit.setCellValue(9.3);

        sheet.autoSizeColumn(1);

        book.write(new FileOutputStream(file));
        book.close();
    }
    
    
}

