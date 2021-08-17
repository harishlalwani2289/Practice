package harish.lamda;

import org.apache.poi.xwpf.usermodel.BreakType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

interface Drawable{
    public void draw();
}
interface Sayable{
    public String say(String name);
}


public class LamdaExpressionExample {

    public static void main(String[] args) {
        int width =10;

        Drawable drawable = () -> System.out.println("Drawing for width :" + width);
        drawable.draw();

        Sayable sayable= (name) -> "Hello " + name;
        System.out.println(sayable.say("Harish"));

        List<String> nameList= new ArrayList<>();
        nameList.add("ankit");
        nameList.add("mayank");
        nameList.add("irfan");
        nameList.add("jai");

        nameList.forEach(
                (name) -> System.out.println(name)
        );

        Runnable runnable1 =new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running");
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Runnable runnable2 = () -> System.out.println("Thread2 is running");
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"HP Laptop",25000f));
        productList.add(new Product(3,"Keyboard",300f));
        productList.add(new Product(2,"Dell Mouse",150f));

        System.out.println("Sortung on basis of name using lambda");

        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        productList.forEach((p) -> System.out.println(p.name));

        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(1,"Samsung A5",17000f));
        productList2.add(new Product(3,"Iphone 6S",65000f));
        productList2.add(new Product(2,"Sony Xperia",25000f));
        productList2.add(new Product(4,"Nokia Lumia",15000f));
        productList2.add(new Product(5,"Redmi4 ",26000f));
        productList2.add(new Product(6,"Lenevo Vibe",19000f));

        Stream<Product> productStream = productList2.stream().filter(p -> p.price> 20000);
        productStream.forEach( product -> System.out.println(product.name + " " + product.price));

    }
}
