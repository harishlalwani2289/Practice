package com.harish.TeamMaker;

import java.util.Comparator;

public class SortByPlayerType implements Comparator<Player> {


    @Override
    public int compare(Player o1, Player o2) {
        return o1.getPlayerType().compareTo(o2.getPlayerType());
    }
}
