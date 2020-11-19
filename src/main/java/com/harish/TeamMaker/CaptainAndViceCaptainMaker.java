package com.harish.TeamMaker;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CaptainAndViceCaptainMaker {

    public static void makeCaptainAndViceCaptain(Team team) {
        List<Player> playersList = team.getTeamPlayers();
        removeCaptainAndViceCaptainIfExisiting(team);
        List<Player> potentialCaptainsAndViceCaptain = playersList.stream()
                .filter(player -> player.getPlayerType().equals(PlayerType.BATSMAN)
                        || player.getPlayerType().equals(PlayerType.ALLROUNDER)
                        //|| player.getPlayerType().equals(PlayerType.BOWLER)
                        || player.getPlayerType().equals(PlayerType.WICKET_KEEPER))
                .collect(Collectors.toList());
        Player captain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
        captain.setCaptain(true);

        Player viceCaptain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
        while(viceCaptain.getCaptain())
            viceCaptain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
        viceCaptain.setViceCaptain(true);
    }

    private static void removeCaptainAndViceCaptainIfExisiting(Team team) {
        team.getTeamPlayers().stream()
                .forEach(player -> {
                    player.setCaptain(false);
                    player.setViceCaptain(false);
                });
    }

    public static void makeCaptainsAndViceCaptains(Team team) {
            List<Player> playerListInTeam = team.getTeamPlayers();
            removeCaptainAndViceCaptainIfExisiting(team);
            List<Player> potentialCaptainsAndViceCaptain = playerListInTeam.stream()
                    .filter(player -> player.getBattingOrder() <= 4)
                    .collect(Collectors.toList());

            /*// Selecting three pairs of captain and vice captain per team
            List<Player> captainAndViceCaptainList = new ArrayList<>();
            for(int j= 0; j < potentialCaptainsAndViceCaptain.size();j++) {
                Player player = potentialCaptainsAndViceCaptain.get((int) (Math.random() * potentialCaptainsAndViceCaptain.size()));
                while(TeamMaking.playerAlreadyInTeam(player, captainAndViceCaptainList))
                    player = potentialCaptainsAndViceCaptain.get((int) (Math.random() * potentialCaptainsAndViceCaptain.size()));
                captainAndViceCaptainList.add(player);
            }
            // print captain and vice captain option
            for(int j= 0; j < captainAndViceCaptainList.size();j++) {
                System.out.println("C: " + captainAndViceCaptainList.get(j) +"  VC: " + captainAndViceCaptainList.get(j+1) );
            }*/

        HashMap<Player,Player> captainViceCaptainMap = new HashMap<>();
        for(int j= 0; j<3;j++){

            Player captain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
            Player viceCaptain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
            while(viceCaptain.equals(captain))
                viceCaptain = potentialCaptainsAndViceCaptain.get((int) (Math.random()* potentialCaptainsAndViceCaptain.size()));
            if(captainViceCaptainMap.isEmpty() || !captainViceCaptainMap.containsKey(captain))
                captainViceCaptainMap.put(captain,viceCaptain);
            else
                j--;
        }

        for (Map.Entry<Player, Player> entry : captainViceCaptainMap.entrySet()) {
            System.out.println("C: " + entry.getKey()+" and VC: "+ entry.getValue());
        }
        //System.out.println(captainViceCaptainMap);
    }
}
