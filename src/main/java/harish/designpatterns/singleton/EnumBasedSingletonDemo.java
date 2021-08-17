package harish.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnumBasedSingletonDemo {

    static void saveToFile(EnumBasedSingleton basicSingleton, String fileName) throws Exception{
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(basicSingleton);
        }
    }

    static EnumBasedSingleton readFromFile(String fileName) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))   {
            return (EnumBasedSingleton) objectInputStream.readObject();
        }
    }

    public static void main(String[] args) throws Exception {

        String fileName = "myFile.bin";

//        EnumBasedSingleton enumBasedSingleton = EnumBasedSingleton.INSTANCE;
//        enumBasedSingleton.setValue(111);
//        saveToFile(enumBasedSingleton, fileName);

        EnumBasedSingleton enumBasedSingleton1 = readFromFile(fileName);
        System.out.println(enumBasedSingleton1.getValue());
    }

}
