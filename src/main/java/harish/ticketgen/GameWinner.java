package harish.ticketgen;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameWinner {

    static final String filePath = "C:\\Users\\1021053\\Desktop\\Tickets_11Apr_2020.xlsx";
    static XSSFWorkbook xssfWorkbook;

    static {
        try {
            xssfWorkbook = new XSSFWorkbook(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static XSSFSheet ticketSheet = xssfWorkbook.getSheet("Tickets_11Apr2020");

    public GameWinner() throws IOException {
    }

    public static List<Ticket> getWinningTickets(List<Integer> calledNumbers, List<Prize> prizeList) {
        List<Ticket> ticketList = getAllTicketList();
        
        // Now that we have got the list of ticket details of each person
        // here we check if any prize they have won by using the list of
        // number called.
        return getTicketsWhichHasWon(ticketList, calledNumbers, prizeList);
    }

    private static List<Ticket> getTicketsWhichHasWon(List<Ticket> ticketList, List<Integer> calledNumbers, List<Prize> prizeList) {

        for(Prize prize : prizeList) {
            switch (prize.getPrizeID()) {
                case "P1":
                    if(!prize.isPrizeWon() && calledNumbers.size() == 13){
                       List<Ticket> tickets = harish.ticketgen.GamesWonByTicket.getTicketsWhichHasWonUnlucky13(ticketList, calledNumbers , prize);
                       if(tickets.size() > 0)
                           prize.setPrizeWon(true);
                    }
            }
        }

        return null;
        //return GamesWonByTicket.getTicketWhichWinsFirstLine(ticketList, calledNumbers, prizeList);
    }


    public static List<Ticket> getAllTicketList() {

        int numberOFTickets = 30;
        int ticketLength = 3;
        int ticketColumnLength = 9;
        List<Ticket> ticketList = new ArrayList<>();

        for(int k = 0 ; k < numberOFTickets ; k++ ) {

            int rowNum = k*5 + 1;

            //Build a ticket object
            Ticket ticket = new Ticket();
            ticket.setPersonName(ticketSheet.getRow(rowNum).getCell(0).getStringCellValue());
            ticket.setTicketNumber(ticketSheet.getRow(rowNum).getCell(1).getStringCellValue());
            Map<Integer, List<Integer>> rowNumbersMap = new HashMap<>();
            // One ticket
            for (int i = 0; i < ticketLength ; i++) {
                Row row = ticketSheet.getRow(++rowNum);
                List<Integer> currentRowNumbers = new ArrayList<>();
                for (int j = 0; j < ticketColumnLength; j++) {
                    Cell cell = row.getCell(j+1);
                    if(cell.getCellType() == CellType.NUMERIC)
                        currentRowNumbers.add((int) cell.getNumericCellValue());
                    else
                        currentRowNumbers.add(0);
                }
                rowNumbersMap.put(i,currentRowNumbers);
            }
            ticket.setRows(rowNumbersMap);
            ticketList.add(ticket);
        }
        return ticketList;
    }
}
