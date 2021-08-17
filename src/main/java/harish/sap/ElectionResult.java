package harish.sap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ElectionResult {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        int numberOfCandidates = 0;
        Election election;
        List<Election> electionList = new ArrayList<>();
        for (int i=0;i<numberOfTestCases;i++) {
            election = new Election();
            election.setNumberOfCandidates(sc.nextInt());
            election.setVotesList(new ArrayList<>());
            for(int j= 0;j<election.getNumberOfCandidates(); j ++) {
                election.getVotesList().add(sc.nextInt());
            }
            electionList.add(election);
        }
        long startTime = System.nanoTime();
        findWinner(electionList);
        long endtime = System.nanoTime();
        System.out.println((endtime - startTime)/1000000000);
    }

    private static void findWinner(List<Election> electionList) {
        for (Election election : electionList) {
            int totalVotes = election.getVotesList().stream().mapToInt(i -> i).sum();
            int max = Collections.max(election.getVotesList());
            if (election.getVotesList().stream().filter(i -> i == max).count() > 1)
                System.out.println("no winner");
            else if (max > totalVotes/2)
                System.out.println("majority winner " + (election.getVotesList().indexOf(max) + 1) );
            else if (max <= totalVotes/2)
                System.out.println("minority winner " + (election.getVotesList().indexOf(max) + 1) );
        }
    }
}

class Election {
    private int numberOfCandidates;
    private List<Integer> votesList;

    public int getNumberOfCandidates() {
        return numberOfCandidates;
    }

    public void setNumberOfCandidates(int numberOfCandidates) {
        this.numberOfCandidates = numberOfCandidates;
    }

    public List<Integer> getVotesList() {
        return votesList;
    }

    public void setVotesList(List<Integer> votesList) {
        this.votesList = votesList;
    }
}
