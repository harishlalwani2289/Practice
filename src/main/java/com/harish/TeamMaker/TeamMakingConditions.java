package com.harish.TeamMaker;



import java.util.List;

public class TeamMakingConditions {

    public static boolean allConditionsAreMet(Team team, double minimumCreditLimit , boolean multipleWicketKeepers) {
        // Each team should have atleast one wicket keeper
        return wicketKeeperCountValidity(team, multipleWicketKeepers)
                && allRoundersCountValidity(team)
                && bowlersCountValidity(team)
                && batsmenCountValidity(team)
                && sixAndFiveCombination(team)
                && checkAtLeastThreeTopOrderInTeam(team)
                && totalCreditShouldBe(team, minimumCreditLimit);
    }

    private static boolean checkAtLeastThreeTopOrderInTeam(Team team) {
        long count = team.getTeamPlayers().stream().filter(player -> player.getBattingOrder() <= 4).count();
        List<Player> listOfPlayersInTeam =  team.getTeamPlayers();
       long countOfTopOrderBatsmanInTeam1 = listOfPlayersInTeam.stream()
               .filter(player -> (player.getBattingOrder() <= 4 && player.getTeamNumber().equals(TeamNumber.TEAM1))).count();
        long countOfTopOrderBatsmanInTeam2 = listOfPlayersInTeam.stream()
                .filter(player -> (player.getBattingOrder() <= 4 && player.getTeamNumber().equals(TeamNumber.TEAM2))).count();
        return count >= 3 && countOfTopOrderBatsmanInTeam1 <= 3 && countOfTopOrderBatsmanInTeam2 <= 3;
    }

    private static boolean totalCreditShouldBe( Team team, double creditMinimumLimit) {
        Double totalCredits = team.getTeamPlayers().stream()
                .map(Player::getCredit)
                .reduce(0.0, Double::sum);
        return totalCredits >= creditMinimumLimit;
    }

    private static boolean sixAndFiveCombination( Team team) {
        long numberOfPlayersInTeam2 = team.getTeamPlayers().stream()
                .filter(player -> player.getTeamNumber().equals(TeamNumber.TEAM2)).count();
        return numberOfPlayersInTeam2 <=7 && numberOfPlayersInTeam2 >= 4;
    }

    private static boolean wicketKeeperCountValidity( Team team, boolean multipleWicketKeepers) {
        List<Player> wicketKeeperList = team.getTeamPlayers();
        long numberOfWicketKeepers = wicketKeeperList.stream()
                .filter(player -> player.getPlayerType().equals(PlayerType.WICKET_KEEPER)).count();
        if(multipleWicketKeepers)
            return numberOfWicketKeepers >= 1;
        else
            return  numberOfWicketKeepers == 1;
    }

    private static boolean allRoundersCountValidity( Team team) {
        List<Player> allRoundersList = team.getTeamPlayers();
        long numberOfAllRounders = allRoundersList.stream()
                .filter(player -> player.getPlayerType().equals(PlayerType.ALLROUNDER)).count();
        //return  numberOfAllRounders >= 1 && numberOfAllRounders <=3;
        return numberOfAllRounders <=4 && numberOfAllRounders >= 2 ;
    }

    private static boolean batsmenCountValidity( Team team) {
        List<Player> batsmenList = team.getTeamPlayers();
        long numberOfBatsmen = batsmenList.stream()
                .filter(player -> player.getPlayerType().equals(PlayerType.BATSMAN)).count();
        return numberOfBatsmen >= 3 && numberOfBatsmen <=5;
    }

    private static boolean bowlersCountValidity( Team team) {
        List<Player> bowlersList = team.getTeamPlayers();
        long numberOfBowlers = bowlersList.stream()
                .filter(player -> player.getPlayerType().equals(PlayerType.BOWLER)).count();
        return numberOfBowlers >= 3 && numberOfBowlers <=5;
    }
}
