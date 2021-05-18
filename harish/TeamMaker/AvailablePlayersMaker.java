package practice.harish.TeamMaker;

import java.util.ArrayList;
import java.util.List;

public class AvailablePlayersMaker {

    // Selecting random players based on their credit and pushing it to the
    // team created
    public List<Player> createAvailablePlayers() {

        List<Player> availablePlayersFromExcel = new ArrayList<>();
        //createAvailablePlayersFromExcel(availablePlayersFromExcel);
        List<Player> availablePlayers = new ArrayList<>();

        //Melbourne Renegades Team Players Big Bash League
        // Aaron Finch (C), Shaun Marsh, Sam Harper (WK), Tom Cooper, Dan Christian, Alex Doolan, Cameron Boyce, Richard Gleeson,
        // Jack Wildermuth, Kane Richardson, Harry Gurney
        availablePlayers.add(new Player("Aaron Finch (C)", PlayerType.BATSMAN, 10.5, TeamNumber.TEAM1, 1));
        availablePlayers.add(new Player("Shaun Marsh", PlayerType.BATSMAN, 9.5, TeamNumber.TEAM1, 2));
        availablePlayers.add(new Player("Sam Harper (WK)", PlayerType.WICKET_KEEPER, 8.0, TeamNumber.TEAM1, 3));
        availablePlayers.add(new Player("Tom Cooper", PlayerType.BATSMAN, 9.0, TeamNumber.TEAM1, 4));
        availablePlayers.add(new Player("Dan Christian", PlayerType.ALLROUNDER, 9.5, TeamNumber.TEAM1));
        availablePlayers.add(new Player("Alex Doolan", PlayerType.BATSMAN, 8.5, TeamNumber.TEAM1));
        availablePlayers.add(new Player("Cameron Boyce", PlayerType.BOWLER, 8.5, TeamNumber.TEAM1));
        availablePlayers.add(new Player("Richard Gleeson", PlayerType.BOWLER, 8.5, TeamNumber.TEAM1));
        availablePlayers.add(new Player("Jack Wildermuth", PlayerType.BOWLER, 8.5, TeamNumber.TEAM1));
        availablePlayers.add(new Player("Kane Richardson", PlayerType.BOWLER, 9.0, TeamNumber.TEAM1));
        availablePlayers.add(new Player("Harry Gurney", PlayerType.BOWLER, 8.5, TeamNumber.TEAM1));

        //Sydney Thunder Team Players Big Bash League
        // Hales, Khawaja, Ferguson(C), Gilkes(WK), Ross, Sams, Nair, Tremain, Green, McAndrew and Cook.
        availablePlayers.add(new Player("Hales", PlayerType.BATSMAN, 9.5, TeamNumber.TEAM2, 1));
        availablePlayers.add(new Player("Khawaja", PlayerType.BATSMAN, 10.0, TeamNumber.TEAM2, 2));
        availablePlayers.add(new Player("Ferguson(C)", PlayerType.BATSMAN, 9.5, TeamNumber.TEAM2, 3));
        availablePlayers.add(new Player("Gilkes(WK)", PlayerType.WICKET_KEEPER, 8.0, TeamNumber.TEAM2));
        availablePlayers.add(new Player("Ross", PlayerType.BATSMAN, 9.0, TeamNumber.TEAM2));
        availablePlayers.add(new Player("D Sams", PlayerType.ALLROUNDER, 9.0, TeamNumber.TEAM2));
        availablePlayers.add(new Player("Arjun Nair", PlayerType.BOWLER, 8.0, TeamNumber.TEAM2));
        availablePlayers.add(new Player("Tremain", PlayerType.BOWLER, 8.5, TeamNumber.TEAM2));
        availablePlayers.add(new Player("Green", PlayerType.BOWLER, 8.5, TeamNumber.TEAM2));
        availablePlayers.add(new Player("McAndrew", PlayerType.ALLROUNDER, 8.5, TeamNumber.TEAM2));
        availablePlayers.add(new Player("Cook", PlayerType.BOWLER, 8.5, TeamNumber.TEAM2));

        return availablePlayers;
    }

}
