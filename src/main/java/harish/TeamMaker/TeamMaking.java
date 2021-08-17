package harish.TeamMaker;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamMaking {

    private void createAvailablePlayersFromExcel(List<Player> availablePlayersFromExcel) throws IOException {

        Workbook playersWorkBook = new XSSFWorkbook(new FileInputStream("Players.xls"));
        Sheet playersSheet = playersWorkBook.getSheet("Players");
        //HSSFWorkbook playersWorkBook = new HSSFWorkbook(new FileInputStream("Players.xls"));
        //HSSFSheet playersSheet = playersWorkBook.getSheet("Players");

        for(int rowCount=0; rowCount<= playersSheet.getLastRowNum();rowCount++) {
            Row row = playersSheet.getRow(rowCount);
            availablePlayersFromExcel.add(new Player(row.getCell(0).getStringCellValue(), PlayerType.valueOf(row.getCell(2).getStringCellValue()),
                    row.getCell(1).getNumericCellValue()));
        }

        playersWorkBook.close();
    }

    private Team makeTeam(List<Player> availablePlayers) {

        List<Player> selectedPlayers = new ArrayList<>();
        Player currentPlayer;
        double creditSum = 0;
        for(int i=0; i < 11 ; i++) {
            currentPlayer = getCurrentPlayer(availablePlayers);

            // We get new player if player is already existing in team
            while(playerAlreadyInList(currentPlayer, selectedPlayers)){
                currentPlayer = getCurrentPlayer(availablePlayers);
            }
            creditSum = creditSum + currentPlayer.getCredit();
            /*if(creditSum > 100) {
                i= i-2;
                creditSum = creditSum - 2*currentPlayer.getCredit();
                continue;
            }*/
            selectedPlayers.add(currentPlayer);
        }

        return new Team(selectedPlayers);
    }

    public Team makeTeamForCaptainAndViceCaptain(List<Player> availablePlayers, Player captain, Player viceCaptain) {
        System.out.println("C:" + captain.getPlayerName() + " V: " + viceCaptain.getPlayerName());
        System.out.println("Team : ");



        return null;
    }

    public static boolean playerAlreadyInList(Player currentPlayer, List<Player> playerList) {
        if(!playerList.isEmpty())
        {
            for (Player player:
                    playerList) {
                if (player.getPlayerName().equals(currentPlayer.getPlayerName()))
                    return true;
            }
        }
        return false;
    }

    private Player getCurrentPlayer(List<Player> availablePlayers) {
        return availablePlayers.get((int) (Math.random()*availablePlayers.size()));
    }

    public static void main(String[] args) {
        List<Team> listOfTeams = new ArrayList<>();

        TeamMaking teamMaking = new TeamMaking();
        AvailablePlayersMaker availablePlayersMaker = new AvailablePlayersMaker();
        TeamMakingConditions teamMakingConditions = new TeamMakingConditions();


        List<Player> availablePlayers = availablePlayersMaker.createAvailablePlayers();
        listOfTeams.add(teamMaking.makeTeam(availablePlayers));
        while(!teamMakingConditions.allConditionsAreMet(listOfTeams.get(0), 98.5, true)) {
            listOfTeams.remove(0);
            listOfTeams.add(teamMaking.makeTeam(availablePlayers));
        }
        //makeCaptainAndViceCaptain(listOfTeams.get(0));
        printTeam(listOfTeams.get(0));
        CaptainAndViceCaptainMaker.makeCaptainsAndViceCaptains(listOfTeams.get(0));
        for(int j= 1 ; j < 20; j++) {
            listOfTeams.add(teamMaking.makeNextTeam(listOfTeams.get(j-1)));
            if( j <= 7) {
                while (!teamMakingConditions.allConditionsAreMet(listOfTeams.get(j),98.5, true)) {
                    listOfTeams.remove(j);
                    listOfTeams.add(teamMaking.makeNextTeam(listOfTeams.get(j - 1)));
                }
            }
            else
            {
                while (!teamMakingConditions.allConditionsAreMet(listOfTeams.get(j),98.5, false)) {
                    listOfTeams.remove(j);
                    listOfTeams.add(teamMaking.makeNextTeam(listOfTeams.get(j - 1)));
                }
            }
            System.out.println("Team" + (j+1));
            //makeCaptainAndViceCaptain(listOfTeams.get(j));
            printTeam(listOfTeams.get(j));
            CaptainAndViceCaptainMaker.makeCaptainsAndViceCaptains(listOfTeams.get(j));
        }
    }

    private  Team makeNextTeam(Team team) {

        TeamMaking teamMaking = new TeamMaking();
        AvailablePlayersMaker availablePlayersMaker = new AvailablePlayersMaker();
        List<Player> excludedPlayers =  getPlayersToBeExcluded(team);

        List<Player> availablePlayers = availablePlayersMaker.createAvailablePlayers();
        List<Player> selectedPlayers = new ArrayList<>();
        Player currentPlayer;
        double creditSum = 0;
        for(int i=0; i < 11 ; i++) {
            currentPlayer = teamMaking.getCurrentPlayer(availablePlayers);

            // We get new player if player is already existing in team
            while(playerAlreadyInList(currentPlayer, selectedPlayers) || playerAlreadyInList(currentPlayer, excludedPlayers)){
                currentPlayer = teamMaking.getCurrentPlayer(availablePlayers);
            }
            creditSum = creditSum + currentPlayer.getCredit();
            if(creditSum > 100) {
                i= i-2;
                creditSum = creditSum - 2*currentPlayer.getCredit();
                continue;
            }
            selectedPlayers.add(currentPlayer);
        }
        return new Team(selectedPlayers);
    }

    private static List<Player> getPlayersToBeExcluded(Team team) {
        // Randomly select 5 players from team to exclude from next team
        List<Player> excludedPlayers = new ArrayList<>();
        for (int i =0 ; i < 5 ; i++) {
            Player removedPlayer = team.getTeamPlayers().get((int) (Math.random()* team.getTeamPlayers().size()));
            while(playerAlreadyInList(removedPlayer, excludedPlayers)){
                removedPlayer = team.getTeamPlayers().get((int) (Math.random()* team.getTeamPlayers().size()));
            }
                excludedPlayers.add(removedPlayer);
        }
        return  excludedPlayers;
    }

    private static void printTeam(Team team) {
        SortByPlayerType sortByPlayerType = new SortByPlayerType();
        List<Player> playersList = team.getTeamPlayers();
        playersList.sort(sortByPlayerType);
        System.out.println(playersList);
    }
}