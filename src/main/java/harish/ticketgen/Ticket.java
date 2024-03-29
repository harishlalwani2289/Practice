package harish.ticketgen;

import java.util.List;
import java.util.Map;

public class Ticket {

    private String ticketNumber;
    private String personName;
    private Map<Integer, List<Integer>> rows;
    private List<harish.ticketgen.Prize> prizesWonByTicket;

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Map<Integer, List<Integer>> getRows() {
        return rows;
    }

    public void setRows(Map<Integer, List<Integer>> rows) {
        this.rows = rows;
    }

    public List<harish.ticketgen.Prize> getPrizesWonByTicket() {
        return prizesWonByTicket;
    }

    public void setPrizesWonByTicket(List<harish.ticketgen.Prize> prizesWonByTicket) {
        this.prizesWonByTicket = prizesWonByTicket;
    }
}
