package harish.random;

import java.util.HashMap;
import java.util.Map;

public class GlobalLogic {

    public static void main(String[] args) {

        String text = "My name is Harish Lalwani. I am working as a Software Engineer. I also love to do cooking.";
        String[] words = text.split(" ");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for(String element : words) {
            if(!wordFrequency.containsKey(element)) {
                wordFrequency.put(element,0);
            }
            wordFrequency.put(element, wordFrequency.get(element) + 1);
        }

        for(Map.Entry entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
