package practice.harish.ticketgen;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrizeExcel {

    public static FileInputStream file;
    public static String filePath = "C:\\Users\\1021053\\Desktop\\Tambola\\TambolaPrizeDemo.xlsx";

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

    public static List<practice.harish.ticketgen.Prize> getAllPrizes() {
        XSSFSheet sheet = workbook.getSheet("Prizes");
        List<practice.harish.ticketgen.Prize> prizeList = new ArrayList<>();

        int rowNum = 2;

        do {

            practice.harish.ticketgen.Prize prize = new practice.harish.ticketgen.Prize();
            prize.setPrizeID(sheet.getRow(rowNum).getCell(1).getStringCellValue());
            prize.setPrizeName(sheet.getRow(rowNum).getCell(2).getStringCellValue());
            prize.setPrizeDescription(sheet.getRow(rowNum).getCell(3).getStringCellValue());
            prize.setPrizeAmount((int) sheet.getRow(rowNum).getCell(4).getNumericCellValue());

            prizeList.add(prize);
            rowNum++;

        } while(sheet.getRow(rowNum) != null && sheet.getRow(rowNum).getCell(1) != null);
        return prizeList;
    }
}
