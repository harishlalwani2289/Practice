package practice.harish.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo {

    public static void main(String[] args) throws Exception {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());

        // Problem with basic singleton
        // 1. Reflection
        // 2. Serialization
        String fileName = "singleton.bin";
        saveToFile(singleton,fileName);
        singleton.setValue(222);

        BasicSingleton singleton1 = readFromFile(fileName);

        System.out.println(singleton == singleton1);
        System.out.println(singleton.getValue());
        System.out.println(singleton1.getValue());

    }

    static void saveToFile(BasicSingleton basicSingleton, String fileName) throws Exception{
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(basicSingleton);
        }
    }

    static BasicSingleton readFromFile(String fileName) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))   {
                return (BasicSingleton) objectInputStream.readObject();
        }
    }
}
