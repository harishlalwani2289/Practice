package practice.harish.ticketgen;

public class Prize {

    private String prizeID;
    private String prizeName;
    private String prizeDescription;
    private Integer prizeAmount;
    private boolean isPrizeWon;

    public String getPrizeID() {
        return prizeID;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public void setPrizeID(String prizeID) {
        this.prizeID = prizeID;
    }

    public String getPrizeDescription() {
        return prizeDescription;
    }

    public void setPrizeDescription(String prizeDescription) {
        this.prizeDescription = prizeDescription;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(Integer prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public boolean isPrizeWon() {
        return isPrizeWon;
    }

    public void setPrizeWon(boolean prizeWon) {
        isPrizeWon = prizeWon;
    }
}
