package harish.csv;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoCSVWrite {


    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("HArish", 23, "Raipur"));
        employeeList.add(new Employee("eHsh", 23, "Rpur"));

        String outputFilePath = "./csvFile.csv";
        writeToCSV(employeeList, outputFilePath);
    }

    private static void writeToCSV(List<? extends Object> records, String outputFilePath) throws NoSuchFieldException, IllegalAccessException {

        List<String> fieldNames = Arrays.stream(records.get(0).getClass().getDeclaredFields())
                        .map(Field::getName).collect(Collectors.toList())
                .stream().sorted().collect(Collectors.toList());

       for(String field : fieldNames) {
       }

    }
}
