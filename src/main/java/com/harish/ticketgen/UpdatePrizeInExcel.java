package com.harish.ticketgen;

import com.harish.ticketgen.model.Prize;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdatePrizeInExcel {

    private static FileInputStream file = null;

    static {
        try {
            file = new FileInputStream("C:\\Users\\1021053\\Desktop\\Tickets_9Apr_2020.xlsx");
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

    public static void main(String[] args) throws IOException {
        // Creating new sheet that will have information about which prize is won by which
        // ticket number
        createPrizeTicketMapSheet();

    }

    private static void createPrizeTicketMapSheet() throws IOException {
        XSSFSheet prizeTicketMapSheet;
        if(workbook.getSheet("PrizeTicketMap") == null) {
            prizeTicketMapSheet = workbook.createSheet("PrizeTicketMap");
        }
        else {
            prizeTicketMapSheet = workbook.getSheet("PrizeTicketMap");
        }

        //Lets get the list of prizes to decide how many number of rows we need in this sheet
        Cell prizeIdCell = prizeTicketMapSheet.createRow(1).createCell(1);
        prizeIdCell.setCellValue("PrizeID");
        prizeIdCell.setCellStyle(getHeaderStyle());

        Cell prizeDescriptionCell = prizeTicketMapSheet.getRow(1).createCell(2);
        prizeDescriptionCell.setCellValue("Prize Description");
        prizeDescriptionCell.setCellStyle(getHeaderStyle());

        Cell prizeMoneyCell = prizeTicketMapSheet.getRow(1).createCell(3);
        prizeMoneyCell.setCellValue("Prize Money");
        prizeMoneyCell.setCellStyle(getHeaderStyle());

        Cell ticket1Cell = prizeTicketMapSheet.getRow(1).createCell(4);
        ticket1Cell.setCellValue("Ticket Number");
        ticket1Cell.setCellStyle(getHeaderStyle());

        Cell ticket2Cell = prizeTicketMapSheet.getRow(1).createCell(5);
        ticket2Cell.setCellValue("Ticket Number");
        ticket2Cell.setCellStyle(getHeaderStyle());

        Cell ticket3Cell = prizeTicketMapSheet.getRow(1).createCell(6);
        ticket3Cell.setCellValue("Ticket Number");
        ticket3Cell.setCellStyle(getHeaderStyle());

        populatePrizeTicketMapSheet(prizeTicketMapSheet);

        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\1021053\\Desktop\\Tickets_9Apr_2020.xlsx"));
        workbook.write(outFile);
        outFile.close();

    }

    private static void populatePrizeTicketMapSheet(XSSFSheet prizeTicketMapSheet) {

        XSSFSheet prizeSheet = workbook.getSheet("Prizes");
        List<Prize> prizeList = new ArrayList<>();
        int rowNum = 2;
        Cell prizeSheetCell = prizeSheet.getRow(rowNum).getCell(1);

        while(prizeSheet.getRow(rowNum) != null && prizeSheetCell != null && prizeSheetCell.getStringCellValue() != "") {
            Prize prize = new Prize();
            prize.setPrizeID(prizeSheetCell.getStringCellValue());
            prize.setPrizeDescription(prizeSheet.getRow(rowNum).getCell(2).getStringCellValue());
            prize.setPrizeMoney((int) prizeSheet.getRow(rowNum).getCell(3).getNumericCellValue());
            prizeList.add(prize);
            rowNum++;
            if(prizeSheet.getRow(rowNum) != null)
                prizeSheetCell = prizeSheet.getRow(rowNum).getCell(1);
        }

        //We have got the prize list here. Now we have to populate the prize ticket Map sheet with these values.

        rowNum = 2;
        for(Prize prize : prizeList) {
            prizeTicketMapSheet.createRow(rowNum).createCell(1).setCellValue(prize.getPrizeID());
            prizeTicketMapSheet.getRow(rowNum).createCell(2).setCellValue(prize.getPrizeDescription());
            prizeTicketMapSheet.getRow(rowNum).createCell(3).setCellValue(prize.getPrizeMoney());
            rowNum++;
        }
    }

    private static CellStyle getHeaderStyle() {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(createFontForTicketCell());

        return style;
    }

    private static Font createFontForTicketCell() {
        Font font = workbook.createFont();
        font.setBold(true);
        return font;
    }
}
