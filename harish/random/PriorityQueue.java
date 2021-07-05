package practice.harish.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue {

    private List<Element> queue;
    public PriorityQueue() {
        queue = new ArrayList<Element>();
    }

    public void insertElement(Element e) {
        queue.add(e);
        Collections.sort(queue);
    }

    public Element pop() {
        return queue.remove(0);
    }

    public void displayQueue() {
        for (Element element : queue) {
            System.out.println(element.value + " with priority " + element.priority);
        }
    }

}
