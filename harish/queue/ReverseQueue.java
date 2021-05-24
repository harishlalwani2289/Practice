package practice.harish.queue;

public class ReverseQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(16);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        Queue reversedQueue = reverseQueue(queue);
        System.out.println(reversedQueue);
    }

    public static Queue reverseQueue(Queue queue) {
        if (queue.isEmpty())
            return queue;

        int data = queue.peek();
        queue.remove();
        reverseQueue(queue);
        queue.insert(data);
        return queue;
    }
}
