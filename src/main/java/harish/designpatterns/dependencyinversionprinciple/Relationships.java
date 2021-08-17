package harish.designpatterns.dependencyinversionprinciple;


import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Relationships implements RelationshipBrowser { // low level module

    private List<Triplet<Person, Relationship, Person>> tripletList = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        tripletList.add(new Triplet<>(parent, Relationship.PARENT, child));
        tripletList.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getTripletList() {
        return tripletList;
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return tripletList.stream()
                .filter(x -> x.getValue0().equals(name) && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}
