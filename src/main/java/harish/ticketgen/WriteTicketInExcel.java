package harish.ticketgen;

import harish.ticketgen.v2.TicketGenerator;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTicketInExcel {

    public static final XSSFWorkbook workbook = new XSSFWorkbook();

    public static void main(String[] args) {

        XSSFSheet sheet = workbook.createSheet("Tickets_18May2020");

        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);


        for (int j = 1; j < 10; j++) {
            sheet.setColumnWidth(j,1000);
        }

        int numberOFTickets = 200;

        for(int k = 0 ; k < numberOFTickets ; k++ ) {

            int[][] ticket = TicketGenerator.getTicket();
            int rowNum = k*5;
            createTicketNumberCell(sheet, ++rowNum, k);
            // One ticket
            for (int i = 0; i < ticket.length; i++) {
                Row row = sheet.createRow(++rowNum);
                row.createCell(0);
                for (int j = 0; j < ticket[0].length; j++) {
                    Cell cell = row.createCell(j+1);
                    if (ticket[i][j] == 0) {
                        cell.setCellStyle(style);
                        cell.setCellValue("");
                    } else {
                        cell.setCellValue(ticket[i][j]);
                        cell.setCellStyle(style);
                    }
                }
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("Tickets_26Apr_2020.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createTicketNumberCell(XSSFSheet sheet, int rowNum, int k) {
        Row ticketNumberRow = sheet.createRow(rowNum);
        Cell ticketNumberCell = ticketNumberRow.createCell(1);
        CellRangeAddress cellAddresses = new CellRangeAddress(rowNum,rowNum,1,9);
        sheet.addMergedRegion(cellAddresses);
        RegionUtil.setBorderTop(BorderStyle.MEDIUM, cellAddresses, sheet);
        RegionUtil.setBorderBottom(BorderStyle.MEDIUM, cellAddresses, sheet);
        RegionUtil.setBorderLeft(BorderStyle.MEDIUM, cellAddresses, sheet);
        RegionUtil.setBorderRight(BorderStyle.MEDIUM, cellAddresses, sheet);
        ticketNumberCell.setCellValue((k<9?"Ticket 0": "Ticket ") + (k + 1));
        ticketNumberCell.setCellStyle(getticketNumberStyle());
    }

    private static CellStyle getticketNumberStyle() {
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
