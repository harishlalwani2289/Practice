package practice.harish.methodrefrences;


import java.util.function.BiFunction;

interface Sayable {
    void say();
}


class Arithmetic {
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(int a, float b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }
}

    public class MethodRefrencesExample {

        public static void saySomething() {
            System.out.println("Hello, this is static method");
        }

        public static void ThreadStatus() {
            System.out.println("Thread is running");
        }

        public static void main(String[] args) {

            // we have defined a functional interface and
            // referring a static method to it's functional method say().
            // The below statements means the say() method is now pointing to say something method
            // of this class
            Sayable sayable = MethodRefrencesExample::saySomething;
            sayable.say();

            Thread thread = new Thread(MethodRefrencesExample::ThreadStatus);
            thread.start();

            BiFunction<Integer, Integer, Integer> biFunction1 = Arithmetic::add;
            BiFunction<Integer, Float, Float> biFunction2 = Arithmetic::add;
            BiFunction<Float, Float, Float> biFunction3 = Arithmetic::add;

            int result1 = biFunction1.apply(10,20);
            System.out.println(result1);

            float result2 = biFunction2.apply(10,20f);
            System.out.println(result2);

            float result3 = biFunction3.apply(10.444f,20f);
            System.out.println(result3);
        }

    }
