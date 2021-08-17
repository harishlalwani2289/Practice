package harish.ticketgen.model;

public class Prize {

    private String prizeID;
    private String prizeDescription;
    private Integer prizeMoney;
    private boolean isPrizeDone;

    public String getPrizeID() {
        return prizeID;
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

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(Integer prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public boolean isPrizeDone() {
        return isPrizeDone;
    }

    public void setPrizeDone(boolean prizeDone) {
        isPrizeDone = prizeDone;
    }
}
