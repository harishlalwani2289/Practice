package practice.harish.designpatterns.dependencyinversionprinciple;

import org.javatuples.Triplet;

import java.util.List;

public class Research { // high-level module
    public Research(Relationships relationships) {
        List<Triplet<Person, Relationship, Person>> tripletList = relationships.getTripletList();
        tripletList.stream().filter(x -> x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
            .forEach(ch -> System.out.println(" John has a child " + ch.getValue2().name));
    }

    public Research(RelationshipBrowser browser) {
        List<Person> johnchildren = browser.findAllChildrenOf("John");
        for(Person person : johnchildren) {
            System.out.println(" John has a child " + person.name);
        }

    }
}
