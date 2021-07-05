package practice.harish.random;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insertElement(new Element(1, 1));
        priorityQueue.insertElement(new Element(2, 4));
        priorityQueue.insertElement(new Element(3, 2));
        priorityQueue.insertElement(new Element(4, 6));
        priorityQueue.insertElement(new Element(5, 3));

        priorityQueue.displayQueue();

        System.out.println("Removing the highest priority element");
        System.out.println(priorityQueue.pop().value);

        System.out.println("After removing the first element eligible");
        priorityQueue.displayQueue();


    }
}
