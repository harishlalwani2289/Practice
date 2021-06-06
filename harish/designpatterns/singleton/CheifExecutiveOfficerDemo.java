package practice.harish.designpatterns.singleton;

public class CheifExecutiveOfficerDemo {
    public static void main(String[] args) {

        CheifExecutiveOfficer ceo = new CheifExecutiveOfficer();
        ceo.setName("Adam smith");
        ceo.setAge(55);

        CheifExecutiveOfficer ceo2 = new CheifExecutiveOfficer();
        System.out.println(ceo2);
    }
}
