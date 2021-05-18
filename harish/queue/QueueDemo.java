package practice.harish.queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.insert(2);
        queue.insert(3);
        queue.insert(77);
        queue.insert(5);
        queue.insert(6);

        System.out.println(queue.front + " " + queue.rear);
        System.out.println("Number of Items in Queue is : " + queue.nItems);

        System.out.println("Front element is : " + queue.peek());

        queue.remove();
        queue.remove();
        queue.remove();

        System.out.println(queue.front + " " + queue.rear);
        System.out.println("Number of Items in Queue is : " + queue.nItems);

        queue.insert(55);
        queue.insert(56);
        queue.insert(57);

        System.out.println(queue.front + " " + queue.rear);
        System.out.println("Number of Items in Queue is : " + queue.nItems);

        queue.remove();
        queue.remove();
        queue.remove();

        System.out.println(queue.front + " " + queue.rear);
        System.out.println("Number of Items in Queue is : " + queue.nItems);

        queue.remove();
        queue.remove();

        System.out.println(queue.front + " " + queue.rear);
        System.out.println("Number of Items in Queue is : " + queue.nItems);
    }
}
