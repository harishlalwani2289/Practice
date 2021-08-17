package harish.TeamMaker;

import java.util.Objects;

public class Player {

    private String playerName;
    private PlayerType playerType;
    private Double credit;
    private boolean isCaptain;
    private boolean isViceCaptain;
    private TeamNumber teamNumber;
    private int battingOrder = 12;

    public Player(String playerName, PlayerType playerType, Double credit) {
        this.playerName = playerName;
        this.playerType = playerType;
        this.credit = credit;
    }

    public Player(String playerName, PlayerType playerType, Double credit, TeamNumber teamNumber) {
        this.playerName = playerName;
        this.playerType = playerType;
        this.credit = credit;
        this.teamNumber = teamNumber;
    }

    public Player(String playerName, PlayerType playerType, Double credit, TeamNumber teamNumber, int battingOrder) {
        this.playerName = playerName;
        this.playerType = playerType;
        this.credit = credit;
        this.teamNumber = teamNumber;
        this.battingOrder = battingOrder;
    }

    public Player(String name, double credit) {
        this.playerName = name;
        this.credit = credit;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public void setViceCaptain(boolean viceCaptain) {
        isViceCaptain = viceCaptain;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public boolean isViceCaptain() {
        return isViceCaptain;
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    @Override
    public String toString() {
        if(this.isViceCaptain)
            return "Vice Captain: " + playerName;
        if(this.isCaptain)
            return "Captain: " + playerName;
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerName.equals(player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    public TeamNumber getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(TeamNumber teamNumber) {
        this.teamNumber = teamNumber;
    }
}
