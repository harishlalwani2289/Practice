package practice.harish.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveAlternateElements {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "a", "b", "c", "d","e","f");

//        for(int i=0;i<stringArrayList.size();i++) {
//            if (i%2 == 1) {
//                stringArrayList.remove(stringArrayList.get(i));
//            }
//        }

//        Iterator iterator = stringArrayList.iterator();
//
//        while(iterator.hasNext()) {
//            if ((int)iterator.next().toString().charAt(0)%2 == 0)
//                iterator.remove();
//        }


        System.out.println(stringArrayList.size());

        stringArrayList.removeIf(p -> p.charAt(0)%2 == 0);

        for(String s : stringArrayList) {
            System.out.println(s);
        }

    }
}
