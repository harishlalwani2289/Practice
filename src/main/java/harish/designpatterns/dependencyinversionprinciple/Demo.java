package harish.designpatterns.dependencyinversionprinciple;

public class Demo {

    public static void main(String[] args) {

        Person john = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(john, child1);
        relationships.addParentAndChild(john, child2);

        new Research(relationships);

    }
}
