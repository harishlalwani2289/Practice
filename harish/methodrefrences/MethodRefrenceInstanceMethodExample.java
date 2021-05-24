package practice.harish.methodrefrences;

public class MethodRefrenceInstanceMethodExample {


    public void saySomething() {
        System.out.println("Hello, this is non static method");
    }

    public void printMessage() {
        System.out.println(" Hello threading, this is an instance method");
    }

    public static void main(String[] args) {

        MethodRefrenceInstanceMethodExample methodRefrenceInstanceMethodExample =
                new MethodRefrenceInstanceMethodExample();

        Sayable sayable = methodRefrenceInstanceMethodExample::saySomething;

        sayable.say();

        Sayable sayable1 = new MethodRefrenceInstanceMethodExample()::saySomething;
        sayable1.say();

        // In the below line we have replaced the runnable target with a instance method
        // So this function will be called when the run of runnable is called
        // This is similar to below commented code
        //Runnable runnable = () -> System.out.println(" Hello threading, this is an instance method");
        // Here the run() method is just printing the line

        Thread thread = new Thread(new MethodRefrenceInstanceMethodExample()::printMessage);
        thread.start();
    }
}
