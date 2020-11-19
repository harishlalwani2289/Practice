package com.harish.hashmaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EmployeeMap {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setName("Harish");
        Employee e2 = new Employee();
        e2.setName("Harilp");
        Map<Employee,Integer> employeeMap = new HashMap<>();

        employeeMap.put(e1,1);
        employeeMap.put(e2,2);

        Set<Map.Entry<Employee,Integer>> entrySet = employeeMap.entrySet();
        Iterator<Map.Entry<Employee,Integer>> itr = entrySet.iterator();

        while (itr.hasNext()){
            Map.Entry<Employee,Integer> employeeEntry = itr.next();
            System.out.println(employeeEntry.hashCode());
        }

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
