package practice.harish.ticketgen;

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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateTicketExcel {

    public static FileInputStream file;
    public static String filePath = "C:\\Users\\1021053\\Desktop\\Tickets_26Apr_2020.xlsx";

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

    public static XSSFSheet sheet;
    public static XSSFSheet hisaabSheet;
    public static XSSFSheet ticketNameMapSheet;

    public UpdateTicketExcel() {
    }

    public static void main(String[] args) throws IOException {

        Cell cell = null;
        sheet = workbook.getSheet("Tickets_26Apr2020");
        Map<String, List<String>> nameTicketsMap = new HashMap<>();
        createNewSheetStructure();
        for(int rowNum = 1; rowNum < 1050 ; rowNum++) {
            if(sheet.getRow(rowNum) != null)
                cell = sheet.getRow(rowNum).getCell(0);
            if(cell != null && cell.getStringCellValue() != "") {
                System.out.println(cell.getStringCellValue());
                if(nameTicketsMap.containsKey(cell.getStringCellValue())){
                    nameTicketsMap.get(cell.getStringCellValue()).add(sheet.getRow(rowNum).getCell(1).getStringCellValue());
                }
                else {
                    List<String> ticketListForPerson = new ArrayList<>();
                    ticketListForPerson.add(sheet.getRow(rowNum).getCell(1).getStringCellValue());
                    nameTicketsMap.put(cell.getStringCellValue(), ticketListForPerson);
                }
            }
        }
        populateHisaabSheet(nameTicketsMap);

        //new sheet to map ticket number, names and winnings
        createOrUpdateTicketNameMapSheet(nameTicketsMap);
    }

    private static void createOrUpdateTicketNameMapSheet(Map<String, List<String>> nameTicketsMap) throws IOException {

        int rowNum =2;

        if(workbook.getSheet("TicketNameMap") == null) {
            ticketNameMapSheet = workbook.createSheet("TicketNameMap");
        }
        else {
            ticketNameMapSheet = workbook.getSheet("TicketNameMap");
        }

        Cell ticketHeader = ticketNameMapSheet.createRow(1).createCell(1);
        ticketHeader.setCellValue("Ticket Number");
        ticketHeader.setCellStyle(getHeaderStyle());

        Cell nameHeader = ticketNameMapSheet.getRow(1).createCell(2);
        nameHeader.setCellValue("Name");
        nameHeader.setCellStyle(getHeaderStyle());

        Cell winning1Header = ticketNameMapSheet.getRow(1).createCell(3);
        winning1Header.setCellValue("Winning1 Amount");
        winning1Header.setCellStyle(getHeaderStyle());

        Cell winning2Header = ticketNameMapSheet.getRow(1).createCell(4);
        winning2Header.setCellValue("Winning2 Amount");
        winning2Header.setCellStyle(getHeaderStyle());

        for(Map.Entry<String, List<String>> entry : nameTicketsMap.entrySet()) {

            Collections.sort(entry.getValue());
            for(String ticketNumber : entry.getValue()) {
                Cell ticketNumberCell = ticketNameMapSheet.createRow(rowNum).createCell(1);
                Cell nameCell = ticketNameMapSheet.getRow(rowNum).createCell(2);
                Cell winning1Cell = ticketNameMapSheet.getRow(rowNum).createCell(3);
                Cell winning2Cell = ticketNameMapSheet.getRow(rowNum).createCell(4);

                winning1Cell.setCellStyle(getDataCellStyle());
                winning2Cell.setCellStyle(getDataCellStyle());

                nameCell.setCellStyle(getDataCellStyle());
                ticketNumberCell.setCellStyle(getDataCellStyle());

                ticketNumberCell.setCellValue(ticketNumber);
                nameCell.setCellValue(entry.getKey());

                rowNum++;
            }
        }
        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        workbook.write(outFile);
        outFile.close();
    }

    private static void populateHisaabSheet(Map<String, List<String>> nameTicketsMap) throws IOException {

        int rowNum = 2;
        int totalNumberOfTickets = 0;
        int totalAmountOfTickets = 0;


        for(Map.Entry<String, List<String>> entry : nameTicketsMap.entrySet()) {
            Cell name = hisaabSheet.createRow(rowNum).createCell(1);
            Cell numberOfTickets = hisaabSheet.getRow(rowNum).createCell(2);
            Cell amount = hisaabSheet.getRow(rowNum).createCell(3);

            name.setCellStyle(getDataCellStyle());
            numberOfTickets.setCellStyle(getDataCellStyle());
            amount.setCellStyle(getDataCellStyle());

            name.setCellValue(entry.getKey());
            numberOfTickets.setCellValue(entry.getValue().size());
            totalNumberOfTickets = totalNumberOfTickets + entry.getValue().size();

            amount.setCellValue(entry.getValue().size()*50);
            totalAmountOfTickets = totalAmountOfTickets + entry.getValue().size()*50;

            rowNum++;
        }

        Cell totalNumberOfTicketCell = hisaabSheet.createRow(rowNum).createCell(2);
        Cell totalAmountCell = hisaabSheet.getRow(rowNum).createCell(3);

        totalNumberOfTicketCell.setCellStyle(getHeaderStyle());
        totalNumberOfTicketCell.setCellValue(totalNumberOfTickets);

        totalAmountCell.setCellStyle(getHeaderStyle());
        totalAmountCell.setCellValue(totalAmountOfTickets);


        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        workbook.write(outFile);
        outFile.close();
    }

    private static CellStyle getDataCellStyle() {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        return  style;
    }

    private static void createNewSheetStructure() throws IOException {

        if(workbook.getSheet("Collected_Amount") == null) {
            hisaabSheet = workbook.createSheet("Collected_Amount");
        }
        else {
            hisaabSheet = workbook.getSheet("Collected_Amount");
        }

        Cell nameHeader = hisaabSheet.createRow(1).createCell(1);
        nameHeader.setCellValue("Name");
        nameHeader.setCellStyle(getHeaderStyle());


        Cell quantityHeader = hisaabSheet.getRow(1).createCell(2);
        quantityHeader.setCellValue("Quantity");
        quantityHeader.setCellStyle(getHeaderStyle());

        Cell amountHeader = hisaabSheet.getRow(1).createCell(3);
        amountHeader.setCellValue("Amount");
        amountHeader.setCellStyle(getHeaderStyle());

        FileOutputStream outFile =new FileOutputStream(new File(filePath));
        workbook.write(outFile);
        outFile.close();

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
