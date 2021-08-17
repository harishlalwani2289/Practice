package harish.classloaders;

import org.apache.poi.ss.usermodel.Cell;

import java.util.ArrayList;

public class DemoClass1 {

    public static void main(String[] args) {
        System.out.println(DemoClass1.class.getClassLoader());

        System.out.println(ArrayList.class.getClassLoader());

        System.out.println(Cell.class.getClassLoader());

    }
}
