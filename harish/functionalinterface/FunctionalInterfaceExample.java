package practice.harish.functionalinterface;

interface Doable {
    default void doIt() {
        System.out.println("Do it now");
    }
}

@FunctionalInterface
interface Sayable1 extends Doable {
    void say(String msg);
}

public class FunctionalInterfaceExample implements Sayable1 {

    public static void main(String[] args) {
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        Sayable1 sayable1 = msg -> System.out.println("Hello buddy!" + msg);
        sayable1.say("Harsha");
        functionalInterfaceExample.say("PRatiksha");
        functionalInterfaceExample.doIt();

    }

    @Override
    public void say(String msg) {
        System.out.println("How are you " + msg);
    }
}


