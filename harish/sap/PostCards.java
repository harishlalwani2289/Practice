package practice.harish.sap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PostCards {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int years = sc.nextInt();

        PostCardsYear postCardsYear;

        List<PostCardsYear> postCardsYearList = new ArrayList<>();

        for (int i=0;i<years;i++) {
            postCardsYear = new PostCardsYear();
            postCardsYear.setNumberOfPostCards(sc.nextInt());
            postCardsYear.setCities(new HashSet<>());
            sc.nextLine();
            for(int j= 0;j<postCardsYear.getNumberOfPostCards();j++) {
                var city = sc.nextLine();
                postCardsYear.getCities().add(city);
            }
            postCardsYearList.add(postCardsYear);
        }

        for(PostCardsYear postCardsYear1 : postCardsYearList) {
            System.out.println(postCardsYear1.getCities().size());
        }
    }
}

class PostCardsYear {

    private int numberOfPostCards;
    private Set<String> cities;

    public int getNumberOfPostCards() {
        return numberOfPostCards;
    }

    public void setNumberOfPostCards(int numberOfPostCards) {
        this.numberOfPostCards = numberOfPostCards;
    }

    public Set<String> getCities() {
        return cities;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }
}
