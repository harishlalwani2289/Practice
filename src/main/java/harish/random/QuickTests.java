package harish.random;

public class QuickTests {
    public static void main(String[] args) {

        int age = 30;
        Animal dog = new Animal(); // We are creating an object here
        dog.age = 2;
        System.out.println("Animal age is:" + dog.age);
        System.out.println("Local Variable age is :" + age);


    }
}

class Animal {
    int age;
}
