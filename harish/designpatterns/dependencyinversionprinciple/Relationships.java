package practice.harish.designpatterns.dependencyinversionprinciple;


import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class Relationships { // low level module

    private List<Triplet<Person, Relationship, Person>> tripletList = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        tripletList.add(new Triplet<>(parent, Relationship.PARENT, child));
        tripletList.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getTripletList() {
        return tripletList;
    }
}
