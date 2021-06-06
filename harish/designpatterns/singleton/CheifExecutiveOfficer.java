package practice.harish.designpatterns.singleton;

public class CheifExecutiveOfficer {

    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CheifExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        CheifExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "CheifExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
