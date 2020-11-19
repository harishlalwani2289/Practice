package com.harish.ticketgen;

import java.util.ArrayList;
import java.util.List;

public class GamesWonByTicket {


    public static List<Ticket> getTicketWhichWinsFirstLine(List<Ticket> ticketList, List<Integer> calledNumbers, List<Prize> prizeList) {

        List<Ticket> ticketsWonFirstLine = new ArrayList<>();
        for(Ticket ticket : ticketList) {
            List<Integer> firstRowNumbers = ticket.getRows().get(0);
            if(isFirstLineCrossed(firstRowNumbers,calledNumbers))
                ticketsWonFirstLine.add(ticket);
        }
        return ticketsWonFirstLine;
    }

    private static boolean isFirstLineCrossed(List<Integer> firstRowNumbers, List<Integer> calledNumbers) {

        for(Integer number : firstRowNumbers) {
            if(number != 0) {
                if(!calledNumbers.contains(number)){
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Ticket> getTicketsWhichHasWonUnlucky13(List<Ticket> ticketList, List<Integer> calledNumbers, Prize prize) {

        List<Ticket> ticketsWonUnlucky13 = new ArrayList<>();

        for (Ticket ticket: ticketList) {
            // For all the numbers in ticket we have to check if it matches with the called numbers
            // If it matches any number then this ticket is not winning unluck13
            if(isTicketWinningUnlucky13(ticket, calledNumbers)) {
                ticketsWonUnlucky13.add(ticket);
            }
        }

        return ticketsWonUnlucky13;
    }

    private static boolean isTicketWinningUnlucky13(Ticket ticket, List<Integer> calledNumbers) {

        for(int i = 0 ; i< ticket.getRows().size() ; i++) {
            if(ticket.getRows().get(i).stream()
                    .filter(integer -> calledNumbers.contains((int) integer)).count() > 0) {
                return false;
            }
        }
        return true;
    }
}
