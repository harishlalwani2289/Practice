package practice.src.main.java.com.harish.ticketgen;

import com.harish.ticketgen.model.Prize;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateWinningAmountInExcel {

    private static FileInputStream file = null;

    static {
        try {
            file = new FileInputStream("C:\\Users\\1021053\\Desktop\\Tambola\\Tickets_7Apr_2020.xlsx");
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

        XSSFSheet prizeTicketMapSheet  = workbook.getSheet("PrizeTicketMap");
        XSSFSheet ticketNameMapSheet = workbook.getSheet("TicketNameMap");
        List<Prize> listOfPrizes = getListOfPrizes();
        int rowNum = 2;


        for(Prize prize : listOfPrizes) {
            List<String> ticketNumbers = getTicketNumbersWon(prizeTicketMapSheet, rowNum);
            if(ticketNumbers.size() > 0)
                updateTheWinningAmount(ticketNameMapSheet, ticketNumbers, prize);
            rowNum++;
        }
        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\1021053\\Desktop\\Tambola\\Tickets_7Apr_2020.xlsx"));
        workbook.write(outFile);
        outFile.close();


    }

    private static List<String> getTicketNumbersWon(XSSFSheet prizeTicketMapSheet, int rowNum) {
        List<String> ticketNumbers = new ArrayList<>();
        for(int columnNumber = 4; columnNumber<6;columnNumber++) {
            if(prizeTicketMapSheet.getRow(rowNum).getCell(columnNumber) != null) {
                int currentTicket = (int) prizeTicketMapSheet.getRow(rowNum).getCell(columnNumber).getNumericCellValue();
                if (currentTicket < 9) {
                    ticketNumbers.add("Ticket0" + currentTicket);
                } else {
                    ticketNumbers.add("Ticket " + currentTicket);
                }
            }
        }
        return ticketNumbers;
    }

    private static void updateTheWinningAmount(XSSFSheet ticketNameMapSheet, List<String> ticketNumbers, Prize prize) {
        int actualPrizePerTicket  = prize.getPrizeMoney()/ticketNumbers.size();

        int rowNum = 2;
        do {
            String ticketNumber = ticketNameMapSheet.getRow(rowNum).getCell(1).getStringCellValue();
            if(ticketNumbers.contains(ticketNumber)) {
                if(ticketNameMapSheet.getRow(rowNum).getCell(3).getNumericCellValue() > 0.0) {
                    ticketNameMapSheet.getRow(rowNum).getCell(4).setCellValue(actualPrizePerTicket);
                }
                else {
                    ticketNameMapSheet.getRow(rowNum).getCell(3).setCellValue(actualPrizePerTicket);
                }
            }
        rowNum++;
        } while (ticketNameMapSheet.getRow(rowNum) != null);
    }


    // this will give us the list of prizes.
    private static List<Prize> getListOfPrizes() {

        XSSFSheet prizeSheet = workbook.getSheet("Prizes");
        List<Prize> prizeList = new ArrayList<>();
        int rowNum = 2;
        Cell prizeSheetCell = prizeSheet.getRow(rowNum).getCell(1);

        while(prizeSheetCell != null && prizeSheetCell.getStringCellValue() != "") {
            Prize prize = new Prize();
            prize.setPrizeID(prizeSheetCell.getStringCellValue());
            prize.setPrizeDescription(prizeSheet.getRow(rowNum).getCell(2).getStringCellValue());
            prize.setPrizeMoney((int) prizeSheet.getRow(rowNum).getCell(3).getNumericCellValue());
            prizeList.add(prize);
            rowNum++;
            prizeSheetCell = prizeSheet.getRow(rowNum).getCell(1);
        }
        return prizeList;
    }

}
