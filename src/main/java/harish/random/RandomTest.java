package harish.random;

import java.util.HashMap;
import java.util.Map;

class A {
    int i =1;
    public void method() {
        System.out.println("Inside A");
    }

}

class B extends A {
    int j =2;
    public void method() {
        System.out.println("Inside B");
    }
    public void methodB(){
        System.out.println("Inside method B");
    }
}
public class RandomTest {

    Boolean b;
    public static void main(String[] args) {
        Double d = 0.0;
        String s  = "56.5";
        short srt = (short) 345555;

        System.out.println((double) d);
        System.out.println(Double.valueOf(s));

        //System.out.println((Date) "20022020");
        System.out.println(new RandomTest().b);

        System.out.println(srt);
        System.out.println((byte) (srt));

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) ->
                name.equals("Freddy") ? oldValue + 9 : oldValue + 10000);

        System.out.println(salaries.get("Freddy"));
        A a = new B();
        System.out.println(a.i);
        a.method();
    }
}
