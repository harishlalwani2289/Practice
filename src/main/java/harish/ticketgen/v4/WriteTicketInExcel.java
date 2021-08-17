package harish.ticketgen.v4;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WriteTicketInExcel {

    public static final XSSFWorkbook workbook = new XSSFWorkbook();

    public static void main(String[] args) {

        XSSFSheet sheet = workbook.createSheet("Tickets_9Apr_2020");

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

            int[][] ticket = harish.ticketgen.v4.TicketGenerator.getTicket();
            //Store the positions stored in 2-d array
            List<Integer> positions = getPositionsWithNumber(ticket);
            int immunityPosition = positions.get(getRandomPosition());
            int rowNum = k*10;

            //Store the positions stored in 2-d array
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
                        if(i == immunityPosition/10 && j == immunityPosition%10)
                            cell.setCellStyle(getImmunityStyle());
                        else
                            cell.setCellStyle(style);
                    }
                }
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("Tickets_9Apr_2020.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CellStyle getImmunityStyle() {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);

        return style;
    }

    private static List<Integer> getPositionsWithNumber(int[][] ticket) {
        List<Integer> positions  = new ArrayList<>();
        for (int i = 0; i < ticket.length; i++) {
            for (int j = 0; j < ticket[0].length; j++) {
                if (ticket[i][j] != 0) {
                    positions.add(i*10 + j);
                }
            }
        }
        return positions;
    }

    private static int getRandomPosition() {
        Random random = new Random();
        return random.nextInt(30);
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
        ticketNumberCell.setCellValue((k<9?"Ticket 0": "Ticket ") + ((k + 1)));
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
