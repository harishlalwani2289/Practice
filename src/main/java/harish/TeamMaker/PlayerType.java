package harish.TeamMaker;

public enum PlayerType {
    WICKET_KEEPER("Wicket Keeper"),
    BATSMAN("Batsman"),
    ALLROUNDER("All Rounder"),
    BOWLER("Bowler");

    private final String playerTypeName;

    public String getPlayerTypeName() {
        return playerTypeName;
    }

    PlayerType(String s) {
        this.playerTypeName = s;
    }
}
