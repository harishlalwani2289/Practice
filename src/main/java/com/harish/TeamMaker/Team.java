package com.harish.TeamMaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private List<Player> teamPlayers;

    public Team(List<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public List<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(ArrayList<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamPlayers=" + teamPlayers +
                '}';
    }
}
