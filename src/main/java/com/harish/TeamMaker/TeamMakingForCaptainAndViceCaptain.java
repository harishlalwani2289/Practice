package com.harish.TeamMaker;

import java.util.List;
import java.util.stream.Collectors;

public class TeamMakingForCaptainAndViceCaptain {

    //  3 teams for given captain and vice captain
    public Team makeTeamForCaptainAndViceCaptain(List<Player> availablePlayers, Player captain, Player viceCaptain) {
        System.out.println("C:" + captain.getPlayerName() + " V: " + viceCaptain.getPlayerName());
        System.out.println("Team : ");
        return null;
    }

    public static void main(String[] args) {
        TeamMakingForCaptainAndViceCaptain teamMakingForCaptainAndViceCaptain = new TeamMakingForCaptainAndViceCaptain();
        List<Player> availablePlayers = new AvailablePlayersMaker().createAvailablePlayers();

        getCaptainAndViceCaptain(availablePlayers);
    }

    // Getting captain and vice captain
    private static void getCaptainAndViceCaptain(List<Player> availablePlayers) {

        List<Player> potentialCaptainsAndViceCaptain = availablePlayers.stream()
                .filter(player -> player.getBattingOrder() <= 4)
                .collect(Collectors.toList());

        Player captain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
        Player viceCaptain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));

        while(viceCaptain.equals(captain))
            viceCaptain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
    }


}
